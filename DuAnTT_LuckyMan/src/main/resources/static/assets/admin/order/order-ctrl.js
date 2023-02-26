app.controller("order-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.form = {};
	$scope.item1s = [];

	$scope.initialize1 = function() {
		//load orders
		$http.get("/rest/orders").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				item.createDate = new Date(item.createDate)
			})
		});

	}
	$scope.initialize = function() {
		//load orderdetail
		$http.get("/rest/orderdetail").then(resp => {
			$scope.item1s = resp.data;
		});

	}
	//Khởi đầu
	$scope.initialize();
	$scope.initialize1();
	//Xóa form
	$scope.reset = function() {
		$scope.form = {
			image: 'cloud-upload.jpg',
		};
	}
	//Hiển thị lên form
	$scope.edit = function(item1) {
		$scope.form = angular.copy(item1);
		$(".nav-tabs a:eq(0)").tab('show')
		
	}
	//Thêm sản phẩm mới
	$scope.create = function() {
		var item1 = angular.copy($scope.form);
		$http.post(`/rest/orderdetail`, item1).then(resp => {
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Thêm mới sản phẩm thành công!");
		}).catch(error => {
			alert("Lỗi thêm mới sản phẩm!");
			console.log("Error", error);
		});
	}
	//Cập nhật sản phẩm
	$scope.update = function() {
		var item1 = angular.copy($scope.form);
		$http.put(`/rest/orderdetail/${item.id}`, item1).then(resp => {
			var index = $scope.item1s.findIndex(p => p.id == item.id);
			$scope.item1s[index] = item1;
			alert("Cập nhật sản phẩm thành công!");
		})
			.catch(error => {
				alert("Lỗi cập nhật sản phẩm!");
				console.log("Error", error);
			});
	}
	//Xóa sản phẩm
	$scope.delete = function(item1) {
		$http.delete(`/rest/orderdetail/${item1.id}`).then(resp => {
			var index = $scope.items.findIndex(p => p.id == item1.id);
			$scope.item1s.splice(index, 1);
			$scope.reset();
			alert("Xóa sản phẩm thành công!");
		})
			.catch(error => {
				alert("Lỗi xóa sản phẩm!");
				console.log("Error", error);
			})
	}
	
	
	
	$scope.pager = {
		page: 0,
		size: 10,
		get item1s() {
			var start = this.page * this.size;
			return $scope.item1s.slice(start, start + this.size);
		},
		get count() {
			return Math.ceil(1.0 * $scope.item1s.length / this.size);
		},
		first() {
			this.page = 0;
		},
		prev() {
			this.page--;
			if (this.page < 0) {
				this.last();
			}
		},
		next() {
			this.page++;
			if (this.page >= this.count) {
				this.first();
			}

		},
		last() {
			this.page = this.count - 1;
		}
	}
	//Upload hình
	$scope.imageChanged = function(files) {
		var data = new FormData();
		data.append('file', files[0]);
		$http.post('/rest/upload/images', data, {
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			$scope.form.image = resp.data.name;
		}).catch(error => {
			alert("Lỗi upload hình ảnh");
			console.log("Error", error);
		});
	}
	$scope.pagera = {
		pagea: 0,
		size: 10,
		get items() {
			var start = this.pagea * this.size;
			return $scope.items.slice(start, start + this.size);
		},
		get count() {
			return Math.ceil(1.0 * $scope.items.length / this.size);
		},
		first() {
			this.pagea = 0;
		},
		prev() {
			this.pagea--;
			if (this.pagea < 0) {
				this.last();
			}
		},
		next() {
			this.pagea++;
			if (this.pagea >= this.count) {
				this.first();
			}

		},
		last() {
			this.pagea = this.count - 1;
		}
	}
	$scope.trangthai = function(id) {
		var order = this.items.find(order => order.id == id);
		if (order.trangthai == "Đã đặt hàng"){
			order.trangthai = "Đang chuẩn bị đơn hàng";
			$http.post(`/rest/orders/trangthai`,order).then(resp => {
				$scope.initianlize();
			})
		}else if(order.trangthai == "Đang chuẩn bị đơn hàng"){
			order.trangthai = "Đang giao hàng";
			$http.post(`/rest/orders/trangthai`,order).then(resp => {
				$scope.initianlize();
			})
		}else if(order.trangthai == "Đang giao hàng"){
			order.trangthai = "Đã giao hàng";
			$http.post(`/rest/orders/trangthai/`,order).then(resp => {
				$scope.initianlize();
			})
		}else if(order.trangthai == "Đã giao hàng"){
			alert("Đơn hàng đã hoàn thành")
		}else{
			alert("Đơn hàng lỗi");
		}
	}
	//Xóa sản phẩm
	$scope.delete = function(item) {
		$http.delete(`/rest/orders/${item.id}`).then(resp => {
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items.splice(index, 1);
			$scope.reset();
			alert("Xóa sản phẩm thành công!");
		})
			.catch(error => {
				alert("Lỗi xóa sản phẩm!");
				console.log("Error", error);
			})
	}
});
