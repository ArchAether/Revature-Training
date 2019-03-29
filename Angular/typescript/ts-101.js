var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var n = 10;
//num='testing';    //won't work!!
var b = true;
var s = "this is a string!";
var arr = [1, 2, 3, 4];
//arr= [1,2,'test'];    //Won't work
/*
tuple: allows you to express an array where the type of a fixed number of
elements is known, but need not be the same
*/
var kv = [1, 'Genesis'];
//Generic array types
var arr2 = [1, 3, 4, 5];
/*
Enums - a way of giving names to sets of numeric values
*/
var Days;
(function (Days) {
    Days[Days["Monday"] = 0] = "Monday";
    Days[Days["Tuesday"] = 1] = "Tuesday";
    Days[Days["Wednesday"] = 2] = "Wednesday";
    Days[Days["Thursday"] = 3] = "Thursday";
    Days[Days["Friday"] = 4] = "Friday";
})(Days || (Days = {}));
;
var today = Days[4];
var yesterday = Days.Thursday;
//Functions can now be given parameter types and return types
function add(a, b) {
    return a + b;
}
function doThings() {
    return 'test';
}
function neverType() {
    throw new Error("Cannot reach end of code!");
}
function anotherNever() {
    while (true) {
    }
}
// type assersions tell the transpiler "i know what i'm doing."
//" similar to typecast. no special checks or restructuring of data"
var something = 'this is a string';
var len = something.length;
var u = {
    id: 1,
    username: "Testuser",
    password: '123',
    useApp: function () {
        console.log('learning');
    }
};
var Point = /** @class */ (function () {
    function Point(x, y) {
        this.x = x;
        this.y = y;
    }
    Point.prototype.getDistance = function () {
        return Math.sqrt(Math.pow(this.x, 2) + this.y * this.y);
    };
    return Point;
}());
var pointA = new Point(5, 6);
console.log(pointA.getDistance());
var Point3D = /** @class */ (function (_super) {
    __extends(Point3D, _super);
    function Point3D(x, y, z) {
        var _this = _super.call(this, x, y) || this;
        _this.z = z;
        return _this;
    }
    //overriding Point's get distance. Must be of the same return type
    Point3D.prototype.getDistance = function () {
        var dist = _super.prototype.getDistance.call(this);
        return Math.sqrt(dist * dist + this.z * this.z);
    };
    return Point3D;
}(Point));
