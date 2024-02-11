import React from 'react'
import { Button} from 'antd';
import styles from './styles.css'

function StatusButton() {
  return (
    <div>
      <Button className={styles.btn}>Publish</Button>
    </div>
  );
}

export default StatusButton;