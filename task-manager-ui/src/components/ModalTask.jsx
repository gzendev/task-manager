import React, { useState } from "react";
import { Button, Modal, Input, TextArea, Form } from 'semantic-ui-react'

const ModalTask = (props) => {
    const { handleClose, updateTask, show, title, description } = props;
    const [inputTitle, setInputTitle] = useState(title);
    const [descTitle, setInputDesc] = useState(description);

    const handleUpdateTask = () => {
        updateTask(inputTitle, descTitle);
        setInputTitle('')
        setInputDesc('')
    };

    const close = () => {
        setInputTitle('')
        setInputDesc('')
        handleClose();
    };
    
    return (
        <Modal open={show}>
            <Modal.Header><Input error={inputTitle? false : true} type="text" name="title" placeholder='Title' value={inputTitle} onInput={e => setInputTitle(e.target.value)} style={{width: "100%"}} /></Modal.Header>
            <Modal.Content>
                <Form>
                    <Form.TextArea error={descTitle? false : true} name="description" placeholder='Description' value={descTitle} onInput={e => setInputDesc(e.target.value)} style={{width: "100%"}} />
                </Form>
            </Modal.Content>
            <Modal.Actions>
                <Button color='black' onClick={close}>
                    Cancel
                </Button>
                <Button
                content="Ok"
                labelPosition='right'
                icon='checkmark'
                positive
                onClick={handleUpdateTask}
                disabled={inputTitle && descTitle? false : true}
                />
            </Modal.Actions>
        </Modal>
    );
};

export default ModalTask;