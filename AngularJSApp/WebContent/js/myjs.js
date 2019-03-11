
//create module
var mymodule=angular.module("myapp",[]);

//create controller
mymodule.controller("MyController1",function($scope){
	//Model code
	$scope.welcome="Welcome to Angular JS";  
});

mymodule.controller("MyController2",function($scope){
	//Model code
	$scope.eid=101;
	$scope.ename="Alex";
	$scope.salary=12000.00;
	
});
mymodule.controller("MyController3",function($scope){
	//Model code
	$scope.student={'sid':5005,'sname':'Amit','marks':75.99};
	});

mymodule.controller("MyController4",function($scope){
	//Model code
	$scope.students=[{'sid':1001,'name':'Amit','marks':81.999},
		{'sid':1002,'name':'Babita','marks':91.565},
		{'sid':1003,'name':'Chandan','marks':77.4545},
		{'sid':1004,'name':'Dharmendra','marks':87.454},
		{'sid':1005,'name':'Eshwar','marks':65.6766}];
	});



mymodule.controller("MyController5",function($scope,$http){
	//Model code
			$http({ 
          url : 'MainServlet',
          method : 'GET'
                 }).then(function(response) {
      	               $scope.employees = response.data;
                     }
	          );
		  });
			
