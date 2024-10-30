/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
             if (xhr.status === 200) {
                let itemsArray = JSON.parse(xhr.responseText);
                let roles_table = document.getElementById('table1');
                let header=document.createElement('tr');
                let id_th =document.createElement('th');
                id_th.innerHTML="ID";
                let name_th =document.createElement('th');
                name_th.innerHTML="Name";
                header.appendChild(id_th);
                header.appendChild(name_th);
                roles_table.appendChild(header);
                
                for (let i = 0; i < itemsArray.length; i++) {
                    let rows=document.createElement("tr");
                    let cells=document.createElement("td");
                    cells.innerHTML=itemsArray[i].name;
                    rows.innerHTML=itemsArray[i].id;
                    rows.appendChild(cells);
                    roles_table.appendChild(rows);
                  }}}}
    xhr.open('GET', 'http://54.206.65.201:8080/cloud24/name_api', true);
    xhr.send(null);


