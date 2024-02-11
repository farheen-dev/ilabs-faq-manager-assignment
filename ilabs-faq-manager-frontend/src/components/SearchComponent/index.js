import React from 'react'
import { Button, Input } from "antd";
import styles from './style.css'

function SearchComponent() {
  return (
    <div className={styles.container}>
      <div className={styles.searchContainer}>
        <Input className={styles.inputfield} placeholder="Search..." />
        <Button className={styles.btn}>Search</Button>
      </div>
    </div>
  );
}

export default SearchComponent;
