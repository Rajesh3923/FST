document.getElementById('studentForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const rno = document.getElementById('rno').value;
    const name = document.getElementById('name').value;

    fetch('/api/students/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ rno: rno, name: name })
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            displayStudents();
        })
        .catch((error) => {
            console.error('Error:', error);
        });
});

// Function to retrieve and display students
function displayStudents() {
    fetch('/api/students/all')
        .then(response => response.json())
        .then(data => {
            const studentList = document.getElementById('studentList');
            studentList.innerHTML = '';
            data.forEach(student => {
                const li = document.createElement('li');
                li.textContent = `Roll No: ${student.rno}, Name: ${student.name}`;
                studentList.appendChild(li);
            });
        })
        .catch(error => console.error('Error fetching students:', error));
}

// Fetch students on page load
// window.onload = displayStudents;
