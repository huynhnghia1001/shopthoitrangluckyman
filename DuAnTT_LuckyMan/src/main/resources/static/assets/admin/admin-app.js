app = angular.module("admin-app", ["ngRoute"]);

app.config(function ($routeProvider){
	$routeProvider
	
	.when("/authorize", {
		templateUrl: "/assets/admin/authority/index.html",
		controller: "authority-ctrl"
	})
	.when("/unauthorized", {
		templateUrl: "/assets/admin/authority/unauthorized.html",
		controller: "authority-ctrl"
	}).when("/account", {
		templateUrl: "/assets/admin/account/index.html",
		controller: "account-ctrl"
	})
	.when("/product", {
		templateUrl: "/assets/admin/product/index1.html",
		controller: "product-ctrl"
	})
	.when("/image", {
		templateUrl: "/assets/admin/image/index1.html",
		controller: "product-ctrl"
	})
	.when("/detail", {
		templateUrl: "/assets/admin/details/index1.html",
		controller: "detail-ctrl"
	})
	.when("/order", {
		templateUrl: "/assets/admin/order/index1.html",
		controller: "order-ctrl"
	})
	.otherwise({
		template: "<h1 class='text-center'>FPT Polytechnic Administration</h1>"
	});
})