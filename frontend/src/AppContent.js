import "./App.css";
import {Route, Routes, useLocation} from "react-router-dom";
import React, {useState} from "react";
import Dashboard from "./component/page/Dashboard";
import Student from "./component/page/Student";
import Registration from "./component/page/Registration";
import Transport from "./component/page/Transport";
import Fee from "./component/page/Fee";
import TimeTable from "./component/page/TimeTable";
import Academics from "./component/page/Academics";
import {Settings} from "@material-ui/icons";
import Logout from "./component/page/Logout";
import Expenses from "./component/page/Expenses";
import Attendance from "./component/page/Attendance";
import SideBar from "./component/Sidebar/SideBar";
import School from "./component/page/schools/School";

export const AppContent = ({flag, handleBooleanChange, setFlag}) => {
    const [sidebarType, setSidebarType] = useState('default');
    const location = useLocation();

    /*   useEffect(() => {
           if (location.pathname.startsWith('/settings')) {
               setSidebarType('settings');
           } else {
               setSidebarType('default');
           }
       }, [location.pathname]);*/

    function getRoutesAndElement() {
        return <Routes>
            <Route path="/" element={<Dashboard/>}/>
            <Route path="/school" element={<School/>}/>
            <Route path="/student" element={<Student/>}/>
            <Route path="/registration" element={<Registration/>}/>s
            <Route path="/transport" element={<Transport/>}/>
            <Route path="/attendance" element={<Attendance/>}/>
            <Route path="/fee" element={<Fee/>}/>
            <Route path="/timeTable" element={<TimeTable/>}/>
            <Route path="/expenses" element={<Expenses/>}/>
            <Route path="/academics" element={<Academics/>}/>
            <Route path="/settings" element={<Settings/>}/>
            <Route path="/logout" element={<Logout/>}/>
            {
            /*
            <Route path="/settings/manage/users" element={<AccountManagementUsers/>}/>
            <Route path="/settings/account" element={<MyUserDetails/>}/>
            <Route path="/settings/manage/business" element={<MyBusinessAccount/>}/>
            <Route path="/settings/invoice" element={<Invoice/>}/>
            <Route path="/settings/thermal/print" element={<Print/>}/>
            <Route path="/settings/pricing" element={<Pricing/>}/>
            <Route path="/settings/help/support" element={<HelpSupport/>}/>
            <Route path="/settings/feedback" element={<Feedback/>}/>
            <Route path="/settings/test" element={<InvoiceGenerator/>}/>
            */
            }

            <Route path="*" element={<> not found</>}/>
        </Routes>;
    }

    return (
        <>
            {/*{flag ? (
                <div>
                    <Routes>
                        <Route path="/" element={<HesabbookHome onBooleanChange={handleBooleanChange}/>}/>
                        <Route path="/user/business" element={<MultiStepForm onBooleanChange={handleBooleanChange}/>}/>
                    </Routes>
                </div>
            ) : (
                <div>
                    {sidebarType === 'default' ? (*/}
            <SideBar>
                {getRoutesAndElement()}
            </SideBar>)
            {/*          )
                    }
                </div>
            )}*/}
        </>
    );
}


