function send() {
    let object = {
        "code": document.getElementById("code_snippet").value
    };

    let json = JSON.stringify(object);

    let xhr = new XMLHttpRequest();
    console.log("in js")
    xhr.open("POST", '/api/code/new', false)
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);

    if (xhr.status == 200) {
        alert("Success!");
    }
}