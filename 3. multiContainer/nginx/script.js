const form = document.querySelector('form');
form.addEventListener('submit', event => {
  event.preventDefault();
  const formData = new FormData(form);
  const name = formData.get('name');
  const email = formData.get('email');
  const password = formData.get('password');
  const data = { name, email,password};
  fetch('http://localhost:8080/api/login', {
    method: 'POST',
    body: JSON.stringify(data),
    headers: {
      'Content-Type': 'application/json'
    }
  })
  .then(response => response.json())
  .then(data => {
              form.reset();
              document.querySelector('#message').innerHTML = data.response;
              console.log(data);
            });
});