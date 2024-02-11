import React, { useState } from "react";
import axios from "axios";
import { Popover } from "antd";
import { EllipsisOutlined, EyeOutlined, CheckCircleOutlined, DeleteOutlined } from "@ant-design/icons";
import styles from './style.css'

function ActionButton() {
  const [open, setOpen] = useState(false);

  const hide = () => {
    setOpen(false);
  };
  const handleOpenChange = (newOpen) => {
    setOpen(newOpen);
  };

  // async function Delete() {
  //   try {
  //     await axios.delete(`http://localhost:8080/api/v1/faq/delete/`);
  //     alert("User Deleted Successfully");
  //   } catch (err) {
  //     alert(err);
  //   }
  // }
  

  return (
    <div>
      <Popover
        content={
          <div>
            <div className={styles.popoverSectionEye}>
              <EyeOutlined /> view
            </div>
            <div className={styles.popoverSectionCheck}>
              <CheckCircleOutlined /> Deactivate
            </div>
            <div>
              <DeleteOutlined 
                // onClick={Delete}
               /> Delete
            </div>
          </div>
        }
        trigger="click"
        open={open}
        onOpenChange={handleOpenChange}
      >
        <EllipsisOutlined />
      </Popover>
    </div>
  );
}

export default ActionButton;;