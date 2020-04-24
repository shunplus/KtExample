package com.shgbit.ktexample.bean

/**
 * @author xushun on  2020/4/4 13:37.
 * Email：shunplus@163.com
 * Des：
 */
data class LoginBean(
    var `data`: DataBean,
    var errorCode: String,
    var exception: Any,
    var iserror: Boolean,
    var message: String
)

data class DataBean(
    var user: User,
    var userData: UserData
)

data class User(
    var admin: Boolean,
    var areaId: String,
    var areaName: String,
    var company: Company,
    var companyid: String,
    var companyname: String,
    var createBy: CreateBy,
    var createDate: Long,
    var dbName: String,
    var delFlag: String,
    var device: String,
    var dogId: String,
    var dp: String,
    var duty: Boolean,
    var email: String,
    var expertType: Int,
    var fuzhuzhixingren: String,
    var global: GlobalXXX,
    var groupsid: String,
    var healthAdmin: String,
    var hyxuser: String,
    var id: String,
    var isAssignAuthor: String,
    var isExpert: String,
    var isNewRecord: Boolean,
    var jobResume: String,
    var loginDate: Long,
    var loginFlag: String,
    var loginIp: String,
    var loginName: String,
    var mobile: String,
    var modpass: String,
    var name: String,
    var newPassword: String,
    var no: String,
    var node: String,
    var office: Office,
    var oldLoginDate: Long,
    var oldLoginIp: String,
    var oldLoginName: String,
    var online: Boolean,
    var origUserType: String,
    var page: PageXXXXXXX,
    var password: String,
    var phone: String,
    var photo: String,
    var provinceCourtCode: String,
    var remarks: String,
    var role: Any,
    var roleIdList: List<String>,
    var roleList: List<Role>,
    var roleNames: String,
    var ruleName: String,
    var score: Int,
    var selectName: String,
    var speciality: String,
    var sqlMap: SqlMapXXXXXXXX,
    var updateBy: UpdateBy,
    var updateDate: Long,
    var userType: String,
    var vehicleFlag: String,
    var workingLife: Int,
    var xiebancount: Int,
    var zhubancount: Int,
    var zhzxapp: String
)

data class UserData(
    var cqaj: Int,
    var createBy: Any,
    var createDate: Any,
    var dbName: String,
    var dbaj: Int,
    var delFlag: String,
    var dsrly: Int,
    var global: GlobalXXXXXXXXXX,
    var id: String,
    var isNewRecord: Boolean,
    var jdcq: Int,
    var jdyj: Int,
    var page: PageXXXXXXXXXX,
    var qacq: Int,
    var qayj: Int,
    var qxyj: Int,
    var remarks: String,
    var sqlMap: SqlMapXXXXXXXXXX,
    var updateBy: Any,
    var updateDate: Any,
    var zjhs: Int,
    var zxxs: Int
)

data class Company(
    var address: String,
    var area: Any,
    var childDeptList: Any,
    var cityId: String,
    var cityName: String,
    var code: String,
    var createBy: Any,
    var createDate: Any,
    var dbName: String,
    var delFlag: String,
    var deployable: String,
    var deputyPerson: Any,
    var director: String,
    var email: String,
    var emailpwd: String,
    var executive: String,
    var fax: String,
    var forcePosition: Int,
    var fyjc: String,
    var global: Global,
    var grade: String,
    var id: String,
    var isNewRecord: Boolean,
    var lat: String,
    var lng: String,
    var master: String,
    var name: String,
    var page: Page,
    var parent: Parent,
    var parentId: String,
    var parentIds: String,
    var phone: String,
    var primaryPerson: Any,
    var remarks: String,
    var sjbmid: String,
    var sort: Int,
    var sqlMap: SqlMapX,
    var superDog: String,
    var type: String,
    var updateBy: Any,
    var updateDate: Any,
    var useable: String,
    var zipCode: String
)

data class CreateBy(
    var admin: Boolean,
    var areaId: String,
    var areaName: String,
    var company: Any,
    var companyid: String,
    var companyname: String,
    var createBy: Any,
    var createDate: Any,
    var dbName: String,
    var delFlag: String,
    var device: String,
    var dogId: String,
    var dp: String,
    var duty: Boolean,
    var email: String,
    var expertType: Int,
    var fuzhuzhixingren: String,
    var global: GlobalXX,
    var groupsid: String,
    var healthAdmin: String,
    var hyxuser: String,
    var id: String,
    var isAssignAuthor: String,
    var isExpert: String,
    var isNewRecord: Boolean,
    var jobResume: String,
    var loginDate: Any,
    var loginFlag: String,
    var loginIp: String,
    var loginName: String,
    var mobile: String,
    var modpass: String,
    var name: String,
    var newPassword: String,
    var no: String,
    var node: String,
    var office: Any,
    var oldLoginDate: Any,
    var oldLoginIp: String,
    var oldLoginName: String,
    var online: Boolean,
    var origUserType: String,
    var page: PageXX,
    var password: String,
    var phone: String,
    var photo: String,
    var provinceCourtCode: String,
    var remarks: String,
    var role: Any,
    var roleIdList: List<Any>,
    var roleList: List<Any>,
    var roleNames: String,
    var ruleName: String,
    var score: Int,
    var selectName: String,
    var speciality: String,
    var sqlMap: SqlMapXX,
    var updateBy: Any,
    var updateDate: Any,
    var userType: String,
    var vehicleFlag: String,
    var workingLife: Int,
    var xiebancount: Int,
    var zhubancount: Int,
    var zhzxapp: String
)

data class GlobalXXX(
    var `$ref`: String
)

data class Office(
    var address: String,
    var area: Area,
    var childDeptList: Any,
    var cityId: String,
    var cityName: String,
    var code: String,
    var createBy: Any,
    var createDate: Any,
    var dbName: String,
    var delFlag: String,
    var deployable: String,
    var deputyPerson: Any,
    var director: String,
    var email: String,
    var emailpwd: String,
    var executive: String,
    var fax: String,
    var forcePosition: Int,
    var fyjc: String,
    var global: GlobalXXXXXX,
    var grade: String,
    var id: String,
    var isNewRecord: Boolean,
    var lat: String,
    var lng: String,
    var master: String,
    var name: String,
    var page: PageXXXXX,
    var parent: ParentXX,
    var parentId: String,
    var parentIds: String,
    var phone: String,
    var primaryPerson: Any,
    var remarks: String,
    var sjbmid: String,
    var sort: Int,
    var sqlMap: SqlMapXXXXXX,
    var superDog: String,
    var type: String,
    var updateBy: Any,
    var updateDate: Any,
    var useable: String,
    var zipCode: String
)

data class PageXXXXXXX(
    var count: Int,
    var disabled: Boolean,
    var eMcount: Int,
    var first: Int,
    var firstPage: Boolean,
    var firstResult: Int,
    var funcName: String,
    var funcParam: String,
    var html: String,
    var last: Int,
    var lastPage: Boolean,
    var list: List<Any>,
    var maxResults: Int,
    var next: Int,
    var notCount: Boolean,
    var orderBy: String,
    var pageIndex: Int,
    var pageSize: Int,
    var prev: Int,
    var totalPage: Int
)

data class Role(
    var createBy: Any,
    var createDate: Any,
    var dataScope: String,
    var dbName: String,
    var delFlag: String,
    var enname: String,
    var global: GlobalXXXXXXXX,
    var id: String,
    var isNewRecord: Boolean,
    var menuIdList: List<Any>,
    var menuIds: String,
    var menuList: List<Any>,
    var name: String,
    var office: Any,
    var officeIdList: List<Any>,
    var officeIds: String,
    var officeList: List<Any>,
    var oldEnname: String,
    var oldName: String,
    var page: PageXXXXXXXX,
    var permissions: List<Any>,
    var remarks: String,
    var roleType: String,
    var sqlMap: SqlMapXXXXXXX,
    var sysData: String,
    var updateBy: Any,
    var updateDate: Any,
    var useable: String,
    var user: Any
)

class SqlMapXXXXXXXX(
)

data class UpdateBy(
    var admin: Boolean,
    var areaId: String,
    var areaName: String,
    var company: Any,
    var companyid: String,
    var companyname: String,
    var createBy: Any,
    var createDate: Any,
    var dbName: String,
    var delFlag: String,
    var device: String,
    var dogId: String,
    var dp: String,
    var duty: Boolean,
    var email: String,
    var expertType: Int,
    var fuzhuzhixingren: String,
    var global: GlobalXXXXXXXXX,
    var groupsid: String,
    var healthAdmin: String,
    var hyxuser: String,
    var id: String,
    var isAssignAuthor: String,
    var isExpert: String,
    var isNewRecord: Boolean,
    var jobResume: String,
    var loginDate: Any,
    var loginFlag: String,
    var loginIp: String,
    var loginName: String,
    var mobile: String,
    var modpass: String,
    var name: String,
    var newPassword: String,
    var no: String,
    var node: String,
    var office: Any,
    var oldLoginDate: Any,
    var oldLoginIp: String,
    var oldLoginName: String,
    var online: Boolean,
    var origUserType: String,
    var page: PageXXXXXXXXX,
    var password: String,
    var phone: String,
    var photo: String,
    var provinceCourtCode: String,
    var remarks: String,
    var role: Any,
    var roleIdList: List<Any>,
    var roleList: List<Any>,
    var roleNames: String,
    var ruleName: String,
    var score: Int,
    var selectName: String,
    var speciality: String,
    var sqlMap: SqlMapXXXXXXXXX,
    var updateBy: Any,
    var updateDate: Any,
    var userType: String,
    var vehicleFlag: String,
    var workingLife: Int,
    var xiebancount: Int,
    var zhubancount: Int,
    var zhzxapp: String
)

data class Global(
    var `$ref`: String
)

data class Page(
    var count: Int,
    var disabled: Boolean,
    var eMcount: Int,
    var first: Int,
    var firstPage: Boolean,
    var firstResult: Int,
    var funcName: String,
    var funcParam: String,
    var html: String,
    var last: Int,
    var lastPage: Boolean,
    var list: List<Any>,
    var maxResults: Int,
    var next: Int,
    var notCount: Boolean,
    var orderBy: String,
    var pageIndex: Int,
    var pageSize: Int,
    var prev: Int,
    var totalPage: Int
)

data class Parent(
    var address: String,
    var area: Any,
    var childDeptList: Any,
    var cityId: String,
    var cityName: String,
    var code: String,
    var createBy: Any,
    var createDate: Any,
    var dbName: String,
    var delFlag: String,
    var deployable: String,
    var deputyPerson: Any,
    var director: String,
    var email: String,
    var emailpwd: String,
    var executive: String,
    var fax: String,
    var forcePosition: Int,
    var fyjc: String,
    var global: GlobalX,
    var grade: String,
    var id: String,
    var isNewRecord: Boolean,
    var lat: String,
    var lng: String,
    var master: String,
    var name: String,
    var page: PageX,
    var parent: Any,
    var parentId: String,
    var parentIds: String,
    var phone: String,
    var primaryPerson: Any,
    var remarks: String,
    var sjbmid: String,
    var sort: Int,
    var sqlMap: SqlMap,
    var superDog: String,
    var type: String,
    var updateBy: Any,
    var updateDate: Any,
    var useable: String,
    var zipCode: String
)

class SqlMapX(
)

data class GlobalX(
    var `$ref`: String
)

data class PageX(
    var count: Int,
    var disabled: Boolean,
    var eMcount: Int,
    var first: Int,
    var firstPage: Boolean,
    var firstResult: Int,
    var funcName: String,
    var funcParam: String,
    var html: String,
    var last: Int,
    var lastPage: Boolean,
    var list: List<Any>,
    var maxResults: Int,
    var next: Int,
    var notCount: Boolean,
    var orderBy: String,
    var pageIndex: Int,
    var pageSize: Int,
    var prev: Int,
    var totalPage: Int
)

class SqlMap(
)

data class GlobalXX(
    var `$ref`: String
)

data class PageXX(
    var count: Int,
    var disabled: Boolean,
    var eMcount: Int,
    var first: Int,
    var firstPage: Boolean,
    var firstResult: Int,
    var funcName: String,
    var funcParam: String,
    var html: String,
    var last: Int,
    var lastPage: Boolean,
    var list: List<Any>,
    var maxResults: Int,
    var next: Int,
    var notCount: Boolean,
    var orderBy: String,
    var pageIndex: Int,
    var pageSize: Int,
    var prev: Int,
    var totalPage: Int
)

class SqlMapXX(
)

data class Area(
    var code: String,
    var createBy: Any,
    var createDate: Any,
    var dbName: String,
    var delFlag: String,
    var global: GlobalXXXX,
    var id: String,
    var isNewRecord: Boolean,
    var name: String,
    var page: PageXXX,
    var parent: ParentX,
    var parentId: String,
    var parentIds: String,
    var remarks: String,
    var sort: Int,
    var spell: String,
    var sqlMap: SqlMapXXXX,
    var type: String,
    var updateBy: Any,
    var updateDate: Any
)

data class GlobalXXXXXX(
    var `$ref`: String
)

data class PageXXXXX(
    var count: Int,
    var disabled: Boolean,
    var eMcount: Int,
    var first: Int,
    var firstPage: Boolean,
    var firstResult: Int,
    var funcName: String,
    var funcParam: String,
    var html: String,
    var last: Int,
    var lastPage: Boolean,
    var list: List<Any>,
    var maxResults: Int,
    var next: Int,
    var notCount: Boolean,
    var orderBy: String,
    var pageIndex: Int,
    var pageSize: Int,
    var prev: Int,
    var totalPage: Int
)

data class ParentXX(
    var address: String,
    var area: Any,
    var childDeptList: Any,
    var cityId: String,
    var cityName: String,
    var code: String,
    var createBy: Any,
    var createDate: Any,
    var dbName: String,
    var delFlag: String,
    var deployable: String,
    var deputyPerson: Any,
    var director: String,
    var email: String,
    var emailpwd: String,
    var executive: String,
    var fax: String,
    var forcePosition: Int,
    var fyjc: String,
    var global: GlobalXXXXXXX,
    var grade: String,
    var id: String,
    var isNewRecord: Boolean,
    var lat: String,
    var lng: String,
    var master: String,
    var name: String,
    var page: PageXXXXXX,
    var parent: Any,
    var parentId: String,
    var parentIds: String,
    var phone: String,
    var primaryPerson: Any,
    var remarks: String,
    var sjbmid: String,
    var sort: Int,
    var sqlMap: SqlMapXXXXX,
    var superDog: String,
    var type: String,
    var updateBy: Any,
    var updateDate: Any,
    var useable: String,
    var zipCode: String
)

class SqlMapXXXXXX(
)

data class GlobalXXXX(
    var `$ref`: String
)

data class PageXXX(
    var count: Int,
    var disabled: Boolean,
    var eMcount: Int,
    var first: Int,
    var firstPage: Boolean,
    var firstResult: Int,
    var funcName: String,
    var funcParam: String,
    var html: String,
    var last: Int,
    var lastPage: Boolean,
    var list: List<Any>,
    var maxResults: Int,
    var next: Int,
    var notCount: Boolean,
    var orderBy: String,
    var pageIndex: Int,
    var pageSize: Int,
    var prev: Int,
    var totalPage: Int
)

data class ParentX(
    var code: String,
    var createBy: Any,
    var createDate: Any,
    var dbName: String,
    var delFlag: String,
    var global: GlobalXXXXX,
    var id: String,
    var isNewRecord: Boolean,
    var name: String,
    var page: PageXXXX,
    var parent: Any,
    var parentId: String,
    var parentIds: String,
    var remarks: String,
    var sort: Int,
    var spell: String,
    var sqlMap: SqlMapXXX,
    var type: String,
    var updateBy: Any,
    var updateDate: Any
)

class SqlMapXXXX(
)

data class GlobalXXXXX(
    var `$ref`: String
)

data class PageXXXX(
    var count: Int,
    var disabled: Boolean,
    var eMcount: Int,
    var first: Int,
    var firstPage: Boolean,
    var firstResult: Int,
    var funcName: String,
    var funcParam: String,
    var html: String,
    var last: Int,
    var lastPage: Boolean,
    var list: List<Any>,
    var maxResults: Int,
    var next: Int,
    var notCount: Boolean,
    var orderBy: String,
    var pageIndex: Int,
    var pageSize: Int,
    var prev: Int,
    var totalPage: Int
)

class SqlMapXXX(
)

data class GlobalXXXXXXX(
    var `$ref`: String
)

data class PageXXXXXX(
    var count: Int,
    var disabled: Boolean,
    var eMcount: Int,
    var first: Int,
    var firstPage: Boolean,
    var firstResult: Int,
    var funcName: String,
    var funcParam: String,
    var html: String,
    var last: Int,
    var lastPage: Boolean,
    var list: List<Any>,
    var maxResults: Int,
    var next: Int,
    var notCount: Boolean,
    var orderBy: String,
    var pageIndex: Int,
    var pageSize: Int,
    var prev: Int,
    var totalPage: Int
)

class SqlMapXXXXX(
)

data class GlobalXXXXXXXX(
    var `$ref`: String
)

data class PageXXXXXXXX(
    var count: Int,
    var disabled: Boolean,
    var eMcount: Int,
    var first: Int,
    var firstPage: Boolean,
    var firstResult: Int,
    var funcName: String,
    var funcParam: String,
    var html: String,
    var last: Int,
    var lastPage: Boolean,
    var list: List<Any>,
    var maxResults: Int,
    var next: Int,
    var notCount: Boolean,
    var orderBy: String,
    var pageIndex: Int,
    var pageSize: Int,
    var prev: Int,
    var totalPage: Int
)

class SqlMapXXXXXXX(
)

data class GlobalXXXXXXXXX(
    var `$ref`: String
)

data class PageXXXXXXXXX(
    var count: Int,
    var disabled: Boolean,
    var eMcount: Int,
    var first: Int,
    var firstPage: Boolean,
    var firstResult: Int,
    var funcName: String,
    var funcParam: String,
    var html: String,
    var last: Int,
    var lastPage: Boolean,
    var list: List<Any>,
    var maxResults: Int,
    var next: Int,
    var notCount: Boolean,
    var orderBy: String,
    var pageIndex: Int,
    var pageSize: Int,
    var prev: Int,
    var totalPage: Int
)

class SqlMapXXXXXXXXX(
)

class GlobalXXXXXXXXXX(
)

data class PageXXXXXXXXXX(
    var count: Int,
    var disabled: Boolean,
    var eMcount: Int,
    var first: Int,
    var firstPage: Boolean,
    var firstResult: Int,
    var funcName: String,
    var funcParam: String,
    var html: String,
    var last: Int,
    var lastPage: Boolean,
    var list: List<Any>,
    var maxResults: Int,
    var next: Int,
    var notCount: Boolean,
    var orderBy: String,
    var pageIndex: Int,
    var pageSize: Int,
    var prev: Int,
    var totalPage: Int
)

class SqlMapXXXXXXXXXX(
)