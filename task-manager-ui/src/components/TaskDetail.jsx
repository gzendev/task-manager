import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { removeSelectedTask, selectedTask } from "../redux/actions/taskActions";
import ModalTask from "./ModalTask";
import { useHistory } from "react-router-dom";

const api = "http://localhost:8080/api/task/";

const TaskDetail = () => {
    const { taskId } = useParams();
    let history = useHistory();
    let task = useSelector((state) => state.task);
    const { id, title, status, description } = task;
    const [show, setShow] = useState(false);
    const dispatch = useDispatch();

    const fetch = async (id) => {
        const response = await axios
            .get(api + `${id}`)
            .catch((err) => {
                console.log("Err: ", err);
            });
        dispatch(selectedTask(response.data));
    };

    const deleteTask = async () => {
        const response = await axios
            .delete(api + `delete/${id}`)
            .catch((err) => {
                console.log("Err: ", err);
            });
        dispatch(removeSelectedTask());
    };

    const update = (title, description) => {
        const response = axios
            .patch(api + 'update', {
                id: `${id}`,
                title: `${title}`, 
                description: `${description}`,
                status: '0',
            })
            .catch((err) => {
                console.log("Err: ", err);
            });
        dispatch(removeSelectedTask());
    };

    const showModal = () => {
        setShow(true);
    };

    const hideModal = () => {
        setShow(false);
    };

    useEffect(() => {
        if (taskId && taskId !== "") fetch(taskId);
        return () => {
            dispatch(removeSelectedTask());
        };
    }, [taskId]);

    const updateTask = (title, description) => {
        update(title, description)
        history.goBack();
    };

    const removeTask = () => {
        deleteTask();
        history.goBack();
    };

    return (
        <div class="ui two column centered grid">
        {Object.keys(task).length === 0 ? (
            <div>...Loading</div>
        ) : (
            <div class="column">
                <div className="ui placeholder segment">
                    <div className="header ui blue label">
                        <h1>{title}</h1>
                    </div>
                    <div><h2 className="ui grey label">{status}</h2></div>
                    <p className="label">{description}</p>
                    <div class="ui two column centered grid">
                        <div class="three column centered row">
                            <ModalTask show={show} handleClose={hideModal} updateTask={updateTask} title={title} description={description} />
                            <div class="column">
                                <button class="ui grey button" onClick={() => history.goBack()}>
                                    <i class="backward icon"></i>Back
                                </button>
                            </div>
                            <div class="column">
                                <button class="ui teal button" onClick={showModal}>
                                    <i class="pencil icon"></i>Edit
                                </button>
                            </div>
                            <div class="column">
                                <button class="ui red button" onClick={removeTask}>
                                    <i class="delete icon"></i>Delete
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )}
        </div>
    )
};

export default TaskDetail;