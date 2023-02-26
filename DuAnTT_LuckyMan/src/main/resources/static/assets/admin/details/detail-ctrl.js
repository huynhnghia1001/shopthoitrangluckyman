app.controller("detail-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.form = {};

	$scope.initialize = function() {
		//load products
		$http.get("/rest/productDetails").then(resp => {
			$scope.items = resp.data;
		});

	}

	//Khởi đầu
	$scope.initialize();
	//Xóa form
	$scope.reset = function() {
		$scope.form = {
			createDate: new Date(),
			image: 'cloud-upload.jpg',
			avaliable: true,
		};
	}
	//Hiển thị lên form
	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show')
		
	}
	//Thêm sản phẩm mới
	$scope.create = function() {
		var item = angular.copy($scope.form);
		$http.post(`/rest/productDetails`, item).then(resp => {
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
		var item = angular.copy($scope.form);
		$http.put(`/rest/productDetails/${item.id}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items[index] = item;
			alert("Cập nhật sản phẩm thành công!");
		})
			.catch(error => {
				alert("Lỗi cập nhật sản phẩm!");
				console.log("Error", error);
			});
	}
	//Xóa sản phẩm
	$scope.delete = function(item) {
		$http.delete(`/rest/productDetails/${item.id}`).then(resp => {
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
	
	$scope.pager = {
		page: 0,
		size: 10,
		get items() {
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
		},
		get count() {
			return Math.ceil(1.0 * $scope.items.length / this.size);
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
	$scope.findsize = function(){
		var item = angular.copy($scope.form);
		$http.get(`/rest/productDetails/findsize/${item.size}`).then(resp => {
			$scope.items = angular.copy(resp.data);
			$scope.reset();
		})
	}
	$scope.findid = function(){
		var item = angular.copy($scope.form);
		$http.get(`/rest/productDetails/findid/${item.id}`).then(resp => {
			$scope.items = angular.copy(resp.data);
			$scope.reset();
		})
	}
});