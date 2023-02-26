const app = angular.module("shopping-cart-app", [])
app.controller("shopping-cart-ctrl", function($scope, $http) {

	//Thêm mới tài khoản
	$scope.create = function() {
		var item = angular.copy($scope.form);
		$http.post(`/rest/accounts`, item).then(resp => {
			var authority = {
				account: { username: item.username },
				role: { id: "USER" }
			};
			$http.post(`/rest/authorities`, authority).then(resp => {
				alert("Đăng kí thành công !")
				location.href = `/security/login/form`
			}).catch(error => {
				alert("Lỗi đăng kí tài khoản !" + error);
				console.log("Error", error);
			})
		}).catch(error => {
			alert("Lỗi đăng kí tài khoản !" + error);
			console.log("Error", error);
		});
	}

	//Đổi mật khẩu
	$scope.doimatkhau = function() {
		var item = angular.copy($scope.form);
		var username = $("#username").text();
		$http.get(`/rest/accounts/${username}`).then(resp => {
			item = resp.data;
			if (item.password == $scope.form.password) {
				if ($scope.form.newpassword == $scope.form.confirmpassword) {
					item.password = $scope.form.newpassword;
					$http.put(`/rest/accounts/${username}`, item).then(resp => {
						alert("Mật khẩu mới là: " + item.password)
						/*location.href = ('/security/logoff');*/
					})
				} else {
					alert("Nhập lại mật khẩu không đúng")
				}
			} else {
				alert("Sai mật khẩu hoặc tài khoản")
			}
			$scope.form = {};
		})

	}
	
	//Quên mật khẩu
	$scope.quenmk = function() {
		var item = angular.copy($scope.form);
		$http.get(`/rest/accounts/${item.username}`).then(resp => {
			item = resp.data;
			if (item.email == $scope.form.email && item.username == $scope.form.username) {
				$http.get(`/rest/accounts/quen/${item.username}`).then(resp => {
				
			    var result = prompt("Mã xác nhận:");
					
					doi = resp.data;
					if (doi == result) {
						window.location.href=`/quenmk/${item.username}`;
					}
					else{
						alert("Mã xác nhận không chính xác")
					}
				})
			} else {
				alert("Username hoặc Email không chính xác")
			}
			
		})

	}
	
	
	$scope.update = function() {
		var item = angular.copy($scope.form);
		var username = $("#username").text();
		$http.get(`/rest/accounts/${username}`).then(resp => {
			item.username = resp.data.username;
			item.password = resp.data.password;
			alert(item.username)
			$http.put(`/rest/accounts/${username}`, item).then(resp => {
				alert("Cập nhật tài khoản thành công!");
			}).catch(error => {
				alert("Lỗi cập nhật tài khoản!");
				console.log("Error", error);
			});
		})
	}
	$scope.imageChanged = function(files) {
		var data = new FormData();
		data.append('file', files[0]);
		$http.post('/rest/upload/images', data, {
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			$scope.form.photo = resp.data.name;
		}).catch(error => {
			alert("Lỗi upload hình ảnh");
			console.log("Error", error);
		});
	}
	
	/* QUẢN LÝ GIỎ HÀNG */
	$scope.cart = {
		items: [],
		//Thêm sản phẩm vào giỏ hàng
		add(id) {
			var item = this.items.find(item => item.id == id);
			if (item) {
				item.product.qty++;
				this.saveToLocalStorage();
			}
			else {
				$http.get(`/rest/productDetails/${id}`).then(resp => {
					resp.data.product.qty = 1;
					this.items.push(resp.data);
					this.saveToLocalStorage();
				})
			}
		},
		//Xóa sản phẩm khỏi giỏ hàng
		remove(id) {
			var index = this.items.findIndex(item => item.id == id);
			this.items.splice(index, 1);
			this.saveToLocalStorage();
		},
		//Xóa sạch các mặt hàng trong giỏ
		clear() {
			this.items = []
			this.saveToLocalStorage();
		},
		//Tính thành tiền của 1 sản phẩm
		amt_of(item) { },
		//Tính tổng số lượng các mặt hàng trong giỏ
		get count() {
			return this.items
				.map(item => item.product.qty)
				.reduce((total, qty) => total += qty, 0);
		},
		//Tỏng thành tiền các mặt hàng trong giỏ
		get amount() {
			return this.items
				.map(item => item.product.qty * item.product.price)
				.reduce((total, qty) => total += qty, 0);
		},
		//Lưu giỏ hàng vào local storage
		saveToLocalStorage() {
			var json = JSON.stringify(angular.copy(this.items));
			localStorage.setItem("cart", json);
		},
		//Đọc giỏ hàng từ local storage
		loadFromLocalStorage() {
			var json = localStorage.getItem("cart");
			this.items = json ? JSON.parse(json) : [];
		}
	}
	$scope.cart.loadFromLocalStorage();

	$scope.order = {
		createDate: new Date(),
		address: "",
		account: { username: $("#username").text() },
		totals(){
			return $scope.cart.items
			    .map(item => item.qty * item.price)
                .reduce((total, qty) => total += qty, 0)
		},
		get orderDetails() {
			return $scope.cart.items.map(item => {
				return {
					image: item.product.image,
					name: item.product.name,
					height: item.height,
					weight:item.weight,
					size: item.size,
					price: item.product.price,
					quantity: item.product.qty,
					color: item.color,
				}
				
			});
		},
		loadcart(){
			return $scope.cart.items.map(item => {
				$http.put(`/rest/products/${item.id},item`).then(resp => {
				}).catch(error => {
					alert("Có sự cố!")
				console.log(error)
				});
			})
		},
        purchase() {
			var order = angular.copy(this);
			order.total =  $("#total").text();

			
			//Thực hiện đặt hàng
			$http.post("/rest/orders", order).then(resp => {
				alert("Đặt hàng thành công!");
				$scope.cart.clear();
			//	location.href = "/order/detail/" + resp.data.id;
				location.href = "/product/list";

			}).catch(error => {
				alert("Đặt hàng lỗi!")
				console.log(error)
			})
		}
	}
})