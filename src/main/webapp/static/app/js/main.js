var pivaApp = angular.module("pivaApp", ['ngRoute']);

pivaApp.config(['$routeProvider', function ($routeProvider){
	$routeProvider.when('/piva', {
	    templateUrl: '/static/app/html/partial/piva.html'
}).when('/piva/edit/:id', {
	    templateUrl: '/static/app/html/partial/editPiva.html'
}).otherwise({
        redirectTo: '/piva'
    });

}]);


pivaApp.controller("pivaCTRL", function($scope, $http, $location){

	var base_url_piva = "/api/piva";
	var base_url_pivare = "/api/pivare";
	var base_url_vrstePiva = "/api/vrste_piva";

	$scope.piva = [];
	$scope.pivare = [];
	$scope.vrstePiva = [];
	$scope.nemaNaStanju = [];
	
	$scope.novoPivo = {};
	$scope.novoPivo.naziv = "";
	$scope.novoPivo.vrstaId = "";
	$scope.novoPivo.procenatAlkohola = "";
	$scope.novoPivo.ibu = "";
	$scope.novoPivo.naStanju  = "";
	$scope.novoPivo.pivaraId = "";


	$scope.trazenoPivo = {};
	$scope.trazenoPivo.naziv = "";
	$scope.trazenoPivo.minIBU = "";
	$scope.trazenoPivo.maxIBU = "";
	$scope.trazenoPivo.nazivPivare = "";
	$scope.trazenoPivo.nemaNaStanju = "";
	

	$scope.pageNum = 0;
	$scope.totalPages = 0;
	$scope.izmena = false;


	var getPiva = function(){
		var config = {params: {}};
		config.params.pageNum = $scope.pageNum;

		if($scope.trazenoPivo.naziv != ""){
			config.params.naziv = $scope.trazenoPivo.naziv;
		}
		if($scope.trazenoPivo.minIBU  != ""){
			config.params.minIBU = $scope.trazenoPivo.minIBU;
		}
		if($scope.trazenoPivo.maxIBU  != ""){
			config.params.maxIBU = $scope.trazenoPivo.maxIBU;
		}
		if($scope.trazenoPivo.nazivPivare  != ""){
			config.params.nazivPivare = $scope.trazenoPivo.nazivPivare;
		}
		if($scope.trazenoPivo.nemaNaStanju  != ""){
			config.params.nemaNaStanju = $scope.trazenoPivo.nemaNaStanju;
		}
		
			

		$http.get(base_url_piva, config)
		.then(
			function success (data){
				$scope.piva = data.data;
				$scope.totalPages = data.headers("totalPages");
				console.log($scope.totalPages);
			});
	};


	var getVrste = function(){
		$http.get(base_url_vrstePiva)
		.then(
			function success (data){
				$scope.vrstePiva = data.data;
			});
	};

	var getPivare = function(){
		$http.get(base_url_pivare)
		.then(
			function success (data){
				$scope.pivare = data.data;
			});
	};

	getPiva();
	getPivare();
	getVrste();

	$scope.addPivo = function(){
		$http.post(base_url_piva, $scope.novoPivo)
		.then(function success(data){
		console.log(data.data);
		alert('Uspesno ste dodali pivo!');
		getPiva();

		$scope.novoPivo.naziv = "";
		$scope.novoPivo.vrstaId = "";
		$scope.novoPivo.procenatAlkohola = "";
		$scope.novoPivo.ibu = "";
		$scope.novoPivo.naStanju = "";
		$scope.novoPivo.pivaraId = "";
		});
	};

	$scope.changePage = function(num){
        $scope.pageNum = $scope.pageNum + num;
        getPiva();

    }
    $scope.obrisi = function(id){
		$http.delete(base_url_piva + "/" + id)
		.then(
			function success(data){
				alert('Pivo je obrisano!');
				$scope.pageNum = 0;
				getPiva();

			},
			function error(data){
				alert('Neuspesno brisanje!');
				console.log(data);
			});
	};

	$scope.izmeniNaDrugojSTR = function(id){
		$location.path("/piva/edit/" + id);
	}


	$scope.trazi = function(){
		$scope.pageNum = 0;
		getPiva();
	}

	$scope.ponistiFilter = function(){
		$scope.trazenoPivo.naziv = "";
		$scope.trazenoPivo.minIBU = "";
		$scope.trazenoPivo.maxIBU = "";
		$scope.trazenoPivo.nazivPivare = "";
		$scope.pageNum = 0;
		getPiva();

	}

	$scope.izmeniNaIstoj = function(id){
    	$scope.izmena = true;
    	$http.get(base_url_piva + "/" + id)
        .then(function success(data){
           $scope.novoPivo = data.data;
        });
      }


     $scope.update = function(){
      	$http.put(base_url_piva + "/" + $scope.novoPivo.id, $scope.novoPivo)
         .then(function success(data){
              alert("Uspešno izmenjeno pivo!");

              $scope.izmena = false;
              getPiva();

              $scope.novoPivo.id = 0;
              $scope.novoPivo.vrstaId = 0;
              $scope.novoPivo.naziv = "";
              $scope.novoPivo.procenatAlkohola  = "";
              $scope.novoPivo.pivaraId = 0;
              $scope.novoPivo.ibu  = "";
              $scope.novoPivo.naStanju  = "";


    	});


    }

    


    $scope.NulaNaSTanju = function(){
    	 $scope.trazenoPivo.nemaNaStanju = 0;
    	 $scope.trazi();
  	   	
    }





});
pivaApp.controller("editCTRL", function($scope, $http, $location, $routeParams){

	var base_url_piva = "/api/piva";
	var base_url_pivare = "/api/pivare";
	var base_url_vrstePiva = "/api/vrste_piva";

	$scope.pivo = {};
	$scope.pivare = [];
	$scope.vrstePiva = [];
	var id = $routeParams.id;

	
	$scope.pivo.naziv = "";
	$scope.pivo.vrstaId = "";
	$scope.pivo.procenatAlkohola = "";
	$scope.pivo.ibu = "";
	$scope.pivo.naStanju = "";
	$scope.pivo.pivaraId = "";

	var getPivo = function(){
		$http.get(base_url_piva + "/" + id)
		.then(
			function success (data){
				$scope.pivo = data.data;

			});
	};

	var getVrste = function(){
		$http.get(base_url_vrstePiva)
		.then(
			function success (data){
				$scope.vrstePiva = data.data;
			});
	};

	var getPivare = function(){
		$http.get(base_url_pivare)
		.then(
			function success (data){
				$scope.pivare = data.data;
			});
	};
	getPivo();
	getVrste();
	getPivare();

	$scope.izmeni = function(){
		$http.put(base_url_piva + "/" + id, $scope.pivo)
		.then(
			function success(data){
				alert('Pivo je uspesno izmenjena!');
				$location.path("/piva");
			});
	}


});