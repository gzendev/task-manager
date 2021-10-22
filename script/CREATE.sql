--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-10-22 08:13:03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 24646)
-- Name: cc; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA cc;


--
-- TOC entry 201 (class 1259 OID 24661)
-- Name: task_id_seq; Type: SEQUENCE; Schema: cc; Owner: -
--

CREATE SEQUENCE cc.task_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 24663)
-- Name: task; Type: TABLE; Schema: cc; Owner: -
--

CREATE TABLE cc.task (
    task_id bigint DEFAULT nextval('cc.task_id_seq'::regclass) NOT NULL,
    title character varying(255) NOT NULL,
    description character varying(255) NOT NULL,
    status smallint DEFAULT 0,
	active boolean NOT NULL DEFAULT true,
	creation_date timestamp(0) without time zone
);


--
-- TOC entry 2987 (class 0 OID 24663)
-- Dependencies: 202
-- Data for Name: task; Type: TABLE DATA; Schema: cc; Owner: -
--

INSERT INTO cc.task (task_id, title, description, status) VALUES (1, 'Crest incremental blue portal', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', 0);
INSERT INTO cc.task (task_id, title, description, status) VALUES (2, 'Beauty Buckinghamshire generate Home Loan Account', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', 0);
INSERT INTO cc.task (task_id, title, description, status) VALUES (3, 'Forward Avon open-source Borders', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', 0);
INSERT INTO cc.task (task_id, title, description, status) VALUES (4, 'Licensed olive Bulgarian Lev analyzing', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', 0);
INSERT INTO cc.task (task_id, title, description, status) VALUES (5, 'systems Avon Checking Account fresh-thinking', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', 0);
INSERT INTO cc.task (task_id, title, description, status) VALUES (6, 'Czech Republic auxiliary bi-directional Maryland', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', 0);
INSERT INTO cc.task (task_id, title, description, status) VALUES (7, 'GB HTTP asymmetric Borders', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', 0);


--
-- TOC entry 2993 (class 0 OID 0)
-- Dependencies: 201
-- Name: task_id_seq; Type: SEQUENCE SET; Schema: cc; Owner: -
--

SELECT pg_catalog.setval('cc.task_id_seq', 1, false);


--
-- TOC entry 2855 (class 2606 OID 24672)
-- Name: task task_pkey; Type: CONSTRAINT; Schema: cc; Owner: -
--

ALTER TABLE ONLY cc.task
    ADD CONSTRAINT task_pkey PRIMARY KEY (task_id);


-- Completed on 2021-10-22 08:13:04

--
-- PostgreSQL database dump complete
--

