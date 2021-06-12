import React, { useReducer, useState } from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Container from "@material-ui/core/Container";
import "./App.css";

const formReducer = (state, event) => {
  if (event.reset) {
    return {
      question: "",
    };
  }
  return {
    ...state,
    [event.name]: event.value,
  };
};

function App() {
  const [formData, setFormData] = useReducer(formReducer, {});
  const [answer, setAnswer] = useState({
    answer: "",
  });

  const handleChange = (event) => {
    setFormData({
      name: event.target.name,
      value: event.target.value,
    });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    console.log(JSON.stringify(formData));
    const getData = await fetch("http://localhost:8000/kb/1/doc/1", {
      method: "POST",
      body: JSON.stringify(formData),
    });
    const resData = await getData.json();
    console.log(resData);
    setAnswer(resData);
  };

  const showAnswer = () => {
    if (answer.answer === "") return null;
    else
      return (
        <div>
          <p>{answer}</p>
        </div>
      );
  };
  return (
    <div className="wrapper">
      <form onSubmit={handleSubmit}>
        <TextField
          id="standard-full-width"
          label="Question"
          style={{ margin: 8, width: "60%" }}
          placeholder="Question"
          fullWidth
          margin="normal"
          InputLabelProps={{
            shrink: true,
          }}
          name="question"
          onChange={handleChange}
          value={formData.question || ""}
        />
        <Container maxWidth="sm">
          <Button variant="contained" color="primary" type="submit">
            Submit
          </Button>
        </Container>
      </form>
      <Container
        maxWidth="sm"
        style={{ outlineStyle: "auto", outlineWidth: "thin" }}
      >
        {showAnswer()}
      </Container>
    </div>
  );
}

export default App;
