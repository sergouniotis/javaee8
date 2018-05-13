--
-- PostgreSQL database cluster dump
--

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--
CREATE ROLE webapp;
ALTER ROLE webapp WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD '1234';




--
-- Database creation
--
CREATE DATABASE webapp;
GRANT ALL PRIVILEGES ON DATABASE webapp to webapp;

--REVOKE ALL ON DATABASE template1 FROM PUBLIC;
--REVOKE ALL ON DATABASE template1 FROM postgres;
--GRANT ALL ON DATABASE template1 TO postgres;
