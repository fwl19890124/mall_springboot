app.service("brandService",function ($http) {
    //从异步请求中读取数据到页面
    this.findAll=function () {
        return $http.get("../brand/findAll");
    };

    this.findPage=function (page, size) {
        return $http.get('../brand/findPage?page=' + page + '&size=' + size);
    };
    
    this.findById=function (id) {
        return $http.get("../brand/findById?id="+id);
    };
    
    this.add=function (entity) {
        return $http.post("../brand/add", entity);
    };

    this.update=function (entity) {
        return $http.post("../brand/updateBrand",entity)
    };

    this.delete=function (selectIds) {
        return $http("../brand/deleteBrand?ids=" + selectIds);
    }
});