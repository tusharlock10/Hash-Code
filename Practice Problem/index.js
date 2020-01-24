// DATE : 24-01-2019
// TEAM : Geek House
// Author : Tushar Jain

const fs = require('fs');
var files = []
fs.readdir('./input', (err, files) => {
for(let x=0; x<files.length; x++){
const FILE_NAME = files[x]
// BOILERPLATE CODE FOR READING ALL THE FILES IN input FOLDER


// MAIN SOURCE CODE
const data = fs.readFileSync(`./input/${FILE_NAME}`);
const inputList = data.toString().split('\n');
const input1 = inputList[0].split(' ');

const maxSlices = Number(input1[0]);  // maximum allowed slices of pizza
const pizzaTypes = Number(input1[1]); // no. of pizza types
const pizzaSlices = inputList[1].split(' '); // slices in each type of pizza (sorted array)

// Strategy ->
// 1) Make variables - slicesToOrder = []; totalSlices = 0;
// 2) traverse pizzaSlices from right to left
// 3) if totalSlices + pizzasSlice is less than maxSlices, unshift its index slicesToOrder and add it in totalSlices
// 4) else skip to next one
// 5) After traversing, dump the answer in a file with no. types of slices on line 1 (i.e. slicesToOrder.length)
//    and elements of slicesToOrder in the next line seperated by space

let slicesToOrder = [];
let totalSlices = 0;

for(let i=pizzaTypes-1; i>=0; i--){
  let pizzaSlice = Number(pizzaSlices[i]);

  if (totalSlices+pizzaSlice < maxSlices){
    slicesToOrder.unshift(i);
    totalSlices+=pizzaSlice
  }
}

let to_write = slicesToOrder.length.toString() + "\n" + slicesToOrder.join(' ')
// MAIN SOURCE CODE ENDS HERE


// BOILERPLATE FOR WRITING AN OUTPUT FILE IN output FOLDER
fs.writeFileSync(`./output/${FILE_NAME.substring(0,FILE_NAME.length-3)}.out`, to_write)
}});