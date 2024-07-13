import React, {useState} from 'react';
import {NavLink, useLocation, useNavigate} from 'react-router-dom';
import {FaHome, FaLock, FaUser} from 'react-icons/fa';
import {BiAnalyse} from 'react-icons/bi';
import {AiFillHeart, AiTwotoneFileExclamation} from 'react-icons/ai';
import {BsCartCheck} from 'react-icons/bs';
import {AnimatePresence, motion} from 'framer-motion';
import SidebarMenu from './SidebarMenu';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import styled from 'styled-components';
import './SideBar.css';

const IconContainer = styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
    width: 30px;
    height: 30px;
    background-color: #2d2d2d;
    border-radius: 5px;
`;

const routes = [
    {path: '/', name: 'Dashboard', icon: <IconContainer><FaHome color="white"/></IconContainer>},
    {path: '/registration', name: 'Registration', icon: <IconContainer><BsCartCheck color="white"/></IconContainer>},
    {
        path: '/student',
        name: 'Student',
        icon: <IconContainer><AiTwotoneFileExclamation color="white"/></IconContainer>,
        subRoutes: [
            {path: '/student/inventory', name: 'Student', icon: <IconContainer><FaUser color="white"/></IconContainer>},
        ]
    },
    {
        path: '/staff',
        name: 'Staff',
        icon: <IconContainer><AiTwotoneFileExclamation color="white"/></IconContainer>,
        subRoutes: [
            {
                path: '/staff/teaching',
                name: 'Teaching Invoice',
                icon: <IconContainer><FaUser color="white"/></IconContainer>
            }, {
                path: '/staff/nonteaching',
                name: 'Non Teaching',
                icon: <IconContainer><FaUser color="white"/></IconContainer>
            }
        ]
    },
    {path: '/transport', name: 'Transport', icon: <IconContainer><BsCartCheck color="white"/></IconContainer>},
    {path: '/attendance', name: 'Attendance', icon: <IconContainer><BsCartCheck color="white"/></IconContainer>},
    {path: '/fee', name: 'Fee', icon: <IconContainer><BsCartCheck color="white"/></IconContainer>},
    {path: '/timeTable', name: 'Time Table', icon: <IconContainer><AiFillHeart color="white"/></IconContainer>},
    {path: '/expenses', name: 'Expenses', icon: <IconContainer><BiAnalyse color="white"/></IconContainer>},
    {path: '/academics', name: 'Academics', icon: <IconContainer><AiFillHeart color="white"/></IconContainer>},
    {path: '/settings', name: 'Settings', icon: <IconContainer><AiFillHeart color="white"/></IconContainer>},
    {path: '/logout', name: 'Logout', icon: <IconContainer><AiFillHeart color="white"/></IconContainer>},
];

const settings = [
    {name: 'Profile', path: '/profile'},
    {name: 'Account', path: '/Account'},
    {name: 'Setting', path: '/settings'},
    {name: 'Dashboard', path: '/'},
    {name: 'Logout', path: '/logout'}
];

const SideBar = ({children}) => {
    const [anchorElUser, setAnchorElUser] = useState(null);
    const [isOpen, setIsOpen] = useState(true);
    const location = useLocation();
    const navigate = useNavigate();
    const handleOpenUserMenu = (event) => {
        setAnchorElUser(event.currentTarget);
    };

    const handleCloseUserMenu = () => {
        setAnchorElUser(null);
    };


    const toggleSidebar = () => {
        setIsOpen(!isOpen);
    };

    const getRouteName = () => {
        const route = routes.find(r => r.path === location.pathname);
        if (route) {
            return route.name;
        } else {
            for (const mainRoute of routes) {
                if (mainRoute.subRoutes) {
                    const subRoute = mainRoute.subRoutes.find(sr => sr.path === location.pathname);
                    if (subRoute) {
                        return subRoute.name;
                    }
                }
            }
        }
        return 'Dashboard';
    };

    const showAnimation = {
        hidden: {width: 0, opacity: 0, transition: {duration: 0.5}},
        show: {opacity: 1, width: "auto", transition: {duration: 0.5}},
    };

    const handleSettingsItemClick = (path) => {
        handleCloseUserMenu();
        navigate(path);
    };

    return (
        <>
            <AppBar position="static">
                <Toolbar variant="dense">
                    <IconButton edge="start" color="inherit" aria-label="menu" sx={{mr: 2}} onClick={toggleSidebar}>
                        <MenuIcon/>
                    </IconButton>
                    <Typography variant="h6" color="inherit" component="div" sx={{flexGrow: 1}}>
                        {getRouteName()}
                    </Typography>
                </Toolbar>
            </AppBar>
            <div className="main-container">
                <motion.div
                    animate={{
                        width: isOpen ? "230px" : "60px",
                        transition: {
                            duration: 0.5,
                            type: "spring",
                            damping: 10,
                        },
                    }}
                    className="sidebar"
                    style={{height: '100vh', overflow: 'hidden'}}
                >
                    <section className="routes"
                             style={{height: 'calc(100vh - 64px)', overflowY: 'auto', overflowX: 'hidden'}}>
                        {routes.map((route, index) => {
                            if (route.subRoutes) {
                                return (
                                    <SidebarMenu
                                        key={route.path}
                                        setIsOpen={setIsOpen}
                                        route={route}
                                        showAnimation={showAnimation}
                                        isOpen={isOpen}
                                    />
                                );
                            }
                            return (
                                <NavLink
                                    to={route.path}
                                    key={index}
                                    className="link"
                                    activeClassName="active"
                                >
                                    <div className="icon">{route.icon}</div>
                                    <AnimatePresence>
                                        {isOpen && (
                                            <motion.div
                                                variants={showAnimation}
                                                initial="hidden"
                                                animate="show"
                                                exit="hidden"
                                                className="link_text"
                                            >
                                                {route.name}
                                            </motion.div>
                                        )}
                                    </AnimatePresence>
                                </NavLink>
                            );
                        })}
                    </section>
                </motion.div>
                <main style={{height: 'calc(100vh - 64px)', overflowY: 'auto', overflowX: 'hidden'}}>
                    {children}
                </main>
            </div>
        </>
    );
};

export default SideBar;
