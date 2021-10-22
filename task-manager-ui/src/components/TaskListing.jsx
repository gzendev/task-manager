import React, { useEffect, useState } from "react";
import axios from "axios";
import { useDispatch, useSelector } from "react-redux";
import { setTasks, removeSelectedTask, taskCreate } from "../redux/actions/taskActions";
import Task from "./Task";
import ModalTask from "./ModalTask";

const api = "http://localhost:8080/api/task/";

const TaskListing = () => {
    const tasks = useSelector((state) => state.allTasks.tasks);
    const dispatch = useDispatch();
    const [show, setShow] = useState(false);
    const [fetch, setFetch] = useState(false);

    const fetchTasks = async () => {
        const response = await axios
            .get(api + "list")
            .catch((err) => {
                console.log("Err: ", err);
            });
        dispatch(setTasks(response.data));
        setFetch(false);
    };

    const showModal = () => {
        setShow(true);
    };

    const hideModal = () => {
        setShow(false);
    };

    const add = (title, description) => {
        const response = axios
            .post(api + 'add', {
                title: `${title}`, 
                description: `${description}`,
                status: '0',
            })
            .catch((err) => {
                console.log("Err: ", err);
            });
        setFetch(true);
        dispatch(taskCreate(response.data));
    };

    const updateTask = (title, description) => {
        add(title, description)
        hideModal();
        setFetch(true)
    };

    useEffect(() => {
        fetchTasks();
    }, [fetch]);

    return (
        <div>
            <div class="ui grid">
                <div class="four column row">
                    <div class="right floated column">
                        <ModalTask show={show} handleClose={hideModal} updateTask={updateTask} />
                        <button class="ui teal button" onClick={showModal}>
                            New Task
                        </button>
                    </div>
                </div>
            </div>
            <div className="ui grid container">
                <Task />
            </div>
        </div>
    )
};

export default TaskListing;