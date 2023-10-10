let students = []
let classroom = []

function getAllStudent() {
    back()
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/students",
        success: function (data) {
            displayStudent(data)
            students = data
        }
    })
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/class",
        success: function (data) {
            classroom = data
        }
    })
}

function displayStudent(data) {
    let content = ""
    for (let i = 0; i < data.length; i++) {
        content += `<tr>
                     <td>${i + 1}</td>
                     <td>${data[i].name}</td>
                     <td>${data[i].email}</td>
                     <td>${data[i].phone}</td>
                     <td>${data[i].address}</td>
                     <td>${data[i].dob}</td>
                     <td>${data[i].classroom.name}</td>
                   
                     <td>
                     <button onclick="displaySave(${data[i].id})"   style="color: black; width: 80px; border-radius: 10px">Update</button>
                     </td>
                     <td>
                     <button onclick="deleteStudent(${data[i].id})"  style="color: black; width: 80px; border-radius: 10px">Delete</button>
                     </td>
                      </tr>`
    }
    document.getElementById("show_student").innerHTML = content;
}

function displaySave(id) {
    if (id !== null) {
        $("#home").hide()
        $("#create").hide()
        $("#update").show()
        localStorage.setItem("id_student",id)
        $.ajax({
            type: "GET",
            url: `http://localhost:8080/api/students/${id}`,
            success: function (data) {
                $("#name_u").val(`${data.name}`)
                $("#phone_u").val(`${data.phone}`)
                $("#email_u").val(`${data.email}`)
                $("#address_u").val(`${data.address}`)
                $("#dob_u").val(`${data.dob}`)
                displayClassroomU(data.classroom.id)
            }
        })
    } else {
        $("#home").hide()
        $("#create").show()
        $("#update").hide()
        displayClassroom()
    }
}

function displayClassroomU(id) {

    let content = `<select id="classroom_u">`
    for (let i = 0; i < classroom.length; i++) {
        if (classroom[i].id === id) {
            content += `<option value="${classroom[i].id}" selected>${classroom[i].name}</option>`
        } else {
            content += `<option value="${classroom[i].id}">${classroom[i].name}</option>`
        }
    }
    document.getElementById(`classroom_select_u`).innerHTML = content
}

function displayClassroom() {
    let content = `<select id="classroom">`
    for (let i = 0; i < classroom.length; i++) {
        content += `<option value="${classroom[i].id}">${classroom[i].name}</option>`
    }
    document.getElementById(`classroom_select`).innerHTML = content
}

function back() {
    $("#home").show()
    $("#create").hide()
    $("#update").hide()
}

function create() {
    let name = $("#name").val();
    let email = $("#email").val();
    let phone = $("#phone").val();
    let address = $("#address").val();
    let classroom = $("#classroom").val();
    let dob = $("#dob").val();
    let student = {
        name: name,
        email: email,
        phone: phone,
        address: address,
        classroom: {
            id: classroom
        },
        dob: dob
    }
    $.ajax({
        url: "http://localhost:8080/api/students",
        type: "POST",
        headers: {
            "Content-type": "Application/json"
        },
        data: JSON.stringify(student),
        success: function () {
            alert("Create success!")
            window.location.href = "student.html"
        },
        error: function (xhr, status, error) {
            console.error(xhr.responseText);
        }
    })
}

function saveStudent() {
    let id = localStorage.getItem("id_student")
    let name = $("#name_u").val();
    let email = $("#email_u").val();
    let phone = $("#phone_u").val();
    let address = $("#address_u").val();
    let classroom = $("#classroom_u").val();
    let dob = $("#dob_u").val();
    let student = {
        id: id,
        name: name,
        email: email,
        phone: phone,
        address: address,
        classroom: {
            id: classroom
        },
        dob: dob
    }
    $.ajax({
        url: "http://localhost:8080/api/students",
        type: "POST",
        headers: {
            "Content-type": "Application/json"
        },
        data: JSON.stringify(student),
        success: function () {
            alert("Update success!")
            window.location.href = "student.html"
        },
        error: function (xhr, status, error) {
            console.error(xhr.responseText);
        }
    })
    event.preventDefault();
}

function deleteStudent(id) {
    if (confirm("Are you sure?")) {
        $.ajax({
            type: "DELETE",
            url: `http://localhost:8080/api/students/${id}`,
            success: function () {
                alert("Delete success!")
                window.location.href = "student.html"
            }
        })
    }
}

function searchName(){
    let arr = []
    let name = $("#search").val()
    for (let i = 0; i < students.length; i++) {
        if (students[i].name.toLowerCase().includes(name.toLowerCase())){
            arr.push(students[i])
        }
    }
    displayStudent(arr)
}