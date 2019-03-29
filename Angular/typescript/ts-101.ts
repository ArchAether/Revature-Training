let n: number = 10;
//num='testing';    //won't work!!

let b: boolean = true;

let s: string = "this is a string!";

let arr: number[] = [1, 2, 3, 4];
//arr= [1,2,'test'];    //Won't work

/* 
tuple: allows you to express an array where the type of a fixed number of 
elements is known, but need not be the same
*/

let kv: [number, string] = [1, 'Genesis'];

//Generic array types
let arr2: Array<number> = [1, 3, 4, 5];

/*
Enums - a way of giving names to sets of numeric values
*/
enum Days {
    Monday, Tuesday, Wednesday, Thursday, Friday
};

let today = Days[4];
let yesterday = Days.Thursday;

//Functions can now be given parameter types and return types
function add(a: number, b: number): number {
    return a + b;
}

function doThings(): any {   //can use any to stop using strict typing
    return 'test';
}

function neverType(): never {    //Never reaches the end of the method.
    throw new Error("Cannot reach end of code!");
}

function anotherNever(): never {
    while (true) {

    }
}

// type assersions tell the transpiler "i know what i'm doing."
//" similar to typecast. no special checks or restructuring of data"

let something: any = 'this is a string';
let len: number = (<string>something).length;

// interfaces allows you to type check combinations of variables
// does not transpile to JS. Only used to help developers

/*
We know that the syntax for defining JS objects is 
let obj = {key: value};

when declaring variables of types, we have the syntax 
let var: type = value

Cannot strictly type properties of variable objects without using interfaces
*/

interface User {
    id: number;
    username: string;
    password: string;
    socialMedia?: string;   //? makes something optional.

    useApp(): void;
}

let u: User = {
    id: 1,
    username: "Testuser",
    password: '123',
    useApp: () => {
        console.log('learning');
    }
}

class Point {
    x: number;
    y: number;

    constructor(x: number, y: number) {
        this.x = x;
        this.y = y;
    }

    getDistance() {
        return Math.sqrt(this.x ** 2 + this.y * this.y);
    }
}

let pointA = new Point(5, 6)
console.log(pointA.getDistance());

class Point3D extends Point {
    z: number;

    constructor(x: number, y: number, z: number) {
        super(x, y);
        this.z = z;
    }
    //overriding Point's get distance. Must be of the same return type
    getDistance() {
        let dist = super.getDistance();
        return Math.sqrt(dist * dist + this.z * this.z);
    }
}

class Animal {
    private name: string;

    constructor(name: string) {
        this.name = name;
    }

    getName(): string {
        return this.name;
    }
    setName(name: string): void {
        this.name = name;
    }
}

let pup = new Animal('Max');
console.log(pup.getName());

//protected only accessable within a class and it's subclasses

class Person {
    protected name; string;

    constructor(name: string) {
        this.name = name;
    }
}

class Employee extends Person {
    private department: string;

    constructor(name: string, department: string) {
        super(name);
        this.department = department;
    }
    
    // fields are public by default, but we can use modifiers
    public getElevatorPitch(){
        return `Hello! my name is ${this.name}, I am an employee in the ${this.department} department.`;
    }
}

//READONLY modifier Can't be changed after creation. Make sure the constructor assigns it.

class Car{
    readonly brand: string;
    readonly numWheels: 4;

    constructor(brand: string){
        this.brand = brand;
    }
}

let c = new Car('Benz');

abstract class Account{
    abstract generateReports(): void;
}
