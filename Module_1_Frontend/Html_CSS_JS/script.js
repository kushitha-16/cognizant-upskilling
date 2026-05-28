let studentForm = document.getElementById("studentForm");
let tableBody = document.getElementById("tableBody");
let message = document.getElementById("message");

let students = JSON.parse(localStorage.getItem("students")) || [];

displayStudents();

studentForm.addEventListener("submit", function(event) {
    event.preventDefault();

    let name = document.getElementById("name").value.trim();
    let email = document.getElementById("email").value.trim();
    let course = document.getElementById("course").value;

    if (name === "" || email === "" || course === "") {
        message.style.color = "red";
        message.innerText = "Please fill all fields.";
        return;
    }

    let student = {
        name: name,
        email: email,
        course: course
    };

    students.push(student);
    localStorage.setItem("students", JSON.stringify(students));

    message.style.color = "green";
    message.innerText = "Student registered successfully.";

    studentForm.reset();
    displayStudents();
});

function displayStudents() {
    tableBody.innerHTML = "";

    students.forEach(function(student) {
        let row = `
            <tr>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.course}</td>
            </tr>
        `;

        tableBody.innerHTML += row;
    });
}

function clearData() {
    localStorage.removeItem("students");
    students = [];
    displayStudents();

    message.style.color = "red";
    message.innerText = "All records cleared.";
}