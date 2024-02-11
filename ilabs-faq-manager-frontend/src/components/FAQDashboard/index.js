import React from "react";
import FAQDashboardHeader from "../FAQDashboardHeader";
import SearchComponent from "../SearchComponent";
import FAQDashboardFooter from '../FAQDashboardFooter'
import FAQTable from '../FAQTable'

const FAQDashboard = () => {
  return (
    <div>
      <FAQDashboardHeader />
      <SearchComponent />
      <FAQTable/>
      <FAQDashboardFooter />
    </div>
  );
};

export default FAQDashboard;
