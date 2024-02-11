import React, { useEffect, useState } from "react";
import axios from "axios";
import { Table } from "antd";
import styles from './style.css'
import ActionButton from '../ActionButton'
import StatusButton from '../StatusButton';

const columns = [
  {
    title: "#",
    dataIndex: "id",
  },
  {
    title: "Question",
    dataIndex: "questionTitle",
  },
  {
    title: "Cateogry",
    dataIndex: "category",
  },
  {
    title: "Status",
    dataIndex: "status",
    render: () => (
      <>
        <StatusButton />
      </>
    ),
  },
  {
    title: "Action",
    dataIndex: "action",
    render: () => (
      <>
        <ActionButton />
      </>
    ),
  },
];

const getRandomuserParams = (params) => ({
  results: params.pagination?.pageSize,
  page: params.pagination?.current,
  ...params,
});

const FAQTable = () => {

   const [data, setData] = useState();
   const [loading, setLoading] = useState(false);
   const [tableParams, setTableParams] = useState({
     pagination: {
       current: 1,
       pageSize: 4,
     },
   });

   const fetchData = () => {
     setLoading(true);
     axios
       .get("http://localhost:8080/api/v1/faq/getFaqs")
       .then(
         (res) => {
           setData(res.data);
           setLoading(false);
           setTableParams({
             ...tableParams,
             pagination: {
               ...tableParams.pagination,
               total: 100,
             },
           });
         },
         (fail) => {
           console.error(fail); // Error!
         }
       )
   };

   useEffect(() => {
     fetchData();
   }, [JSON.stringify(tableParams)]);

   const handleTableChange = (pagination, filters, sorter) => {
     setTableParams({
       pagination,
       filters,
       ...sorter,
     });
     // `dataSource` is useless since `pageSize` changed
     if (pagination.pageSize !== tableParams.pagination?.pageSize) {
       setData([]);
     }
   };

  return (
    <div>
      <Table
        className={styles.container}
        columns={columns}
        rowKey={(data) => data.id}
        dataSource={data}
        pagination={tableParams.pagination}
        loading={loading}
        onChange={handleTableChange}
      />
    </div>
  );
};

export default FAQTable;
