import React, {useState} from 'react'
import { useNavigate } from 'react-router-dom';
import axios from "axios";
import { Link } from "react-router-dom";
import { Button, Form, Input } from "antd";
import styles from './styles.css'

const onFinish = (values) => {
  console.log("Success:", values);
};
const onFinishFailed = (errorInfo) => {
  console.log("Failed:", errorInfo);
};

function SingIn() {

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

   async function login(event) {
     event.preventDefault();
     try {
       await axios
         .post("http://localhost:8080/api/v1/user/signIn", {
           username: username,
           password: password,
         })
         .then(
           (res) => {
             console.log(res.data);

             if (res.data.message == "Username not exits") {
               alert("Username not exits");
             } else if (res.data.message == "Login Success") {
               navigate("/dashboard");
             } else {
               alert("Incorrect Username and Password not match");
             }
           },
           (fail) => {
             console.error(fail); // Error!
           }
         );
     } catch (err) {
       alert(err);
     }
   }
        
  return (
    <div className={styles.container}>
      <h1>Welcome to iLabs - FAQ Manager</h1>
      <h3> log in to your account from below</h3>
      <Form
        className={styles.formsection}
        name="basic"
        labelCol={{
          span: 8,
        }}
        wrapperCol={{
          span: 16,
        }}
        style={{
          maxWidth: 600,
        }}
        initialValues={{
          remember: true,
        }}
        onFinish={onFinish}
        onFinishFailed={onFinishFailed}
        autoComplete="off"
      >
        <Form.Item
          label="Username"
          name="username"
          rules={[
            {
              required: true,
              message: "Please input your username!",
            },
          ]}
        >
          <Input
            name="username"
            value={username}
            onChange={(event) => {
             setUsername(event.target.value);
            }}
           />
        </Form.Item>

        <Form.Item
          label="Password"
          name="password"
          rules={[
            {
              required: true,
              message: "Please input your password!",
            },
          ]}
        >
          <Input.Password
            name="password"
            value={password}
            onChange={(event) => {
              setPassword(event.target.value);
            }}
           />
        </Form.Item>

        <Form.Item
          wrapperCol={{
            offset: 8,
            span: 16,
          }}
        >
          <Button className={styles.btn} type="primary" htmlType="submit" onClick={login}>
            SignIn
          </Button>
        </Form.Item>
      </Form>
      <p>
        New to the platform? <Link to="/signup">create an account</Link>
      </p>
    </div>
  );
}

export default SingIn;
