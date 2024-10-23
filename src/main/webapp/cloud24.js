/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
console.log("Hello");
let clickButton=document.getElementById("clickButton");
clickButton.addEventListener("click",function (){
    alert("Hi");
    clickButton.style.backgroundColor = "#7FFF00";
});
let timeButton = document.getElementById("TimeButton");

timeButton.addEventListener("click", function() {
    fetch('cloud24/time')
        .then(response => response.text())
        .then(time => {
            alert("Server Time: " + time);
        })
        .catch(error => console.error('Error:', error));
});

