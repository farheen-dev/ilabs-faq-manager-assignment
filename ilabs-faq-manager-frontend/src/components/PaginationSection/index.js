import React from 'react'
import { Pagination } from "antd";
import styles from './style.css'

function PaginationSection() {
  return (
    <div className={styles.container}>
      <Pagination
        className={styles.paginationPart}
        total={85}
        showTotal={(total, range) => `${range[0]}-${range[1]} of ${total}`}
        defaultPageSize={20}
        defaultCurrent={1}
      />
    </div>
  );
}

export default PaginationSection;