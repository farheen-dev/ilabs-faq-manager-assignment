import React, {useState} from 'react'
import axios from "axios";
import { Button, Modal, Form, Input, Select } from "antd";
import { PlusCircleOutlined } from "@ant-design/icons";
import styles from "./style.css"


function FAQDashboardHeader() {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [question, setQuestion] = useState("");
  const [questionCategory, setQuestionCategory] = useState("About Company");

  async function save() {
    try {
      await axios.post("http://localhost:8080/api/v1/faq/saveFaq", {
        questionTitle: question,
        category: questionCategory,
      });
    } catch (err) {
      alert(err);
    }
  }    

   const handleOk = () => {
     setIsModalOpen(false);
     save();
   };

  const showModal = () => {
    setIsModalOpen(true);
  };

  const handleCancel = () => {
    setIsModalOpen(false);
  };    

  const onFinish = (values) => {
    console.log("Success:", values);
  };
  const onFinishFailed = (errorInfo) => {
    console.log("Failed:", errorInfo);
  };

  return (
    <div>
      <div className={styles.container}>
        <h2>FAQ Manager - iLabs </h2>
        <Button className={styles.btn} onClick={showModal}>
          <PlusCircleOutlined className={styles.pluscircle} />
          Add New Question
        </Button>
        <Modal
          open={isModalOpen}
          title="Add Questions"
          onOk={handleOk}
          onCancel={handleCancel}
        >
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
              label="Question"
              name="question"
              rules={[
                {
                  required: true,
                },
              ]}
            >
              <Input
                name="question"
                value={question}
                onChange={(event) => {
                  setQuestion(event.target.value);
                }}
              />
            </Form.Item>
            <Form.Item label="Category" name="category">
              <Select
                name="category"
                ref="myselect"
                defaultValue="Company"
                style={{ width: 120 }}
                options={[{ value: "About Company", label: "Company" }]}
              />
            </Form.Item>
          </Form>
        </Modal>
      </div>
    </div>
  );
}

export default FAQDashboardHeader;
