<html>
<head>
	<meta charset="utf-8">
	<title>Vyber sposobu stravovania GTI</title>

<style>
		
form {
  /* Center the form on the page */
  margin: 0 auto;
  width: 500px;
  /* Form outline */
  padding: 2em;
  border: 2px solid #CCC;
  border-radius: 5em;
}

ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

form li + li {
  margin-top: 1em;
}

label {
  /* Uniform size & alignment */
  display: inline-block;
  width: 160px;
  text-align: right;
}

input,
textarea {

  /* Uniform text field size */
  width: 300px;
  box-sizing: border-box;

  /* Match form field borders */
  border: 1px solid #999;
}


.button {
  /* Align buttons with the text fields */
  padding-left: 160px; /* same size as the label elements */
}

button {
  /* This extra margin represent roughly the same space as the space
     between the labels and their text fields */
  margin-left: .5em;
}


</style>
</head>
<body>

<form action="/lazy_docs/gastro" method="POST">
 <ul>
 	<h3><center>VYBER SPOSOBU STRAVOVANIA V GTI</center></h3>
  <li>
    <label for="name">Meno a priezvisko:</label>
    <input type="text" id="name" name="fullName" required>
  </li>
  <li>
    <label for="mail">Adresa:</label>
    <input type="text" id="lastName" name="address" required>
  </li>
  <li>
    <label for="msg">Datum narodenia:</label>
    <input type="text" id="address" name="birthDate" required>
  </li>

  <li>

    <label for="card">
        <span>Stravovanie:</span>
      </label>
      <select id="card" name="option">
        <option value="option_card">Formou stravovacej poukazky (karta)</option>
        <option value="option_bonus">Poskytnutim financneho prispevku</option>
      </select>

  </li>
  <li class="button">
  <button type="submit">Stiahnut dokument</button>
</li>
 </ul>
</form>

</body>
</html>
