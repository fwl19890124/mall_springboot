app.controller("brandController",function ($scope,$controller,brandService) {
    //继承
    $controller("baseController",{$scope: $scope});

    //从异步请求中读取数据到页面
    $scope.findAll=function () {
        brandService.findAll().success(function (data) {
            $scope.list = data;
        });
    };

    //分页
    $scope.findPage=function (page, size) {
        brandService.findPage(page, size).success(function (data) {
            $scope.list = data.rows;
            $scope.paginationConf.totalItems = data.total;
        });
    }

    //根据id加载数据
    $scope.findById=function (id) {
        brandService.findById(id).success(function (data) {
            console.log(data);
            $scope.entity = data;
        });
    }


    //新增品牌
    $scope.add = function () {
        var serviceObject=brandService.add($scope.entity);
        // var methodName = "add";
        if ($scope.entity.id != null) {
            serviceObject = brandService.update($scope.entity);
        }
       serviceObject.success(function (data) {
            if (data.success) {
                $scope.reloadList();
            } else {
                alert(data.message);
            }
        });

    };

    //删除品牌
    $scope.delete = function () {
       brandService.delete($scope.selectIds).success(function (data) {
            //保存成功，重新加载数据
            if (data.success) {
                $scope.reloadList();
            } else {
                alert(data.message);
            }
        });

    };

})