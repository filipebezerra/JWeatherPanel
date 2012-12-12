-- Role: filipebezerra

-- DROP ROLE filipebezerra;

CREATE ROLE filipebezerra LOGIN
  ENCRYPTED PASSWORD 'md5d987683f0bc02cb0f7dabbf5a449863d'
  SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;
-------------------------------------------------------------
-- Tablespace: jweatherpanel

-- DROP TABLESPACE jweatherpanel

CREATE TABLESPACE jweatherpanel
  OWNER filipebezerra
  LOCATION '/home/vmuser02/data/db/postgresql/jweatherpanel';
-------------------------------------------------------------
-- Sequence: seq_weather_id

-- DROP SEQUENCE seq_weather_id;

CREATE SEQUENCE seq_weather_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 2147483647
  START 1
  CACHE 1;
ALTER TABLE seq_weather_id
  OWNER TO postgres;
-------------------------------------------------------------
-- Table: weather_consults

-- DROP TABLE weather_consults;

CREATE TABLE weather_consults
(
  id integer NOT NULL, -- codigo unico e sequencial,...
  "originalDate" time without time zone NOT NULL DEFAULT now(), -- data original do momento da consulta no webservice,...
  country character varying(50) NOT NULL, -- pais,...
  city character varying(80) NOT NULL, -- cidade,...
  location text NOT NULL, -- localização exata da tempo pequisa,...
  "time" timestamp with time zone NOT NULL, -- data/hora,...
  wind text NOT NULL, -- vento,...
  visibility character varying(20) NOT NULL, -- visibilidade,...
  "skyConditions" character varying(15) NOT NULL, -- condições do céu,...
  temperature character varying(15) NOT NULL, -- temperatura,...
  windchill character varying(15) NOT NULL, -- sensação do tempo,...
  "dewPoint" character varying(15) NOT NULL, -- ponto de orvalho,...
  "relativeHumidity" real NOT NULL, -- humidade relativa do ar,...
  pressure real NOT NULL, -- pressão,...
  CONSTRAINT weather_consults_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE weather_consults
  OWNER TO postgres;
COMMENT ON TABLE weather_consults
  IS 'Tabela responsavel por armazenar cada consulta realizada ao webservice Global Weather. Os dados retornados pelo cliente que consome o webservice serão persistidos nesta tabela e a cada novo registro desta tabela será cascateado uma copia deste registro para a tabela que armazena o historico permanente dos dados do webservice (tabela weather_history).
Esta tabela poderá sofrer qualquer operação SQL (create, retrieve, update ou delete).';
COMMENT ON COLUMN weather_consults.id IS 'codigo unico e sequencial,
gerado automaticamente pelo sgbd.';
COMMENT ON COLUMN weather_consults."originalDate" IS 'data original do momento da consulta no webservice,
gerado automaticamente pelo sgbd.';
COMMENT ON COLUMN weather_consults.country IS 'pais,
argumento de pesquisa para o webservice.';
COMMENT ON COLUMN weather_consults.city IS 'cidade,
argumento de pesquisa para webservice.';
COMMENT ON COLUMN weather_consults.location IS 'localização exata da tempo pequisa,
retornado pelo webservice.';
COMMENT ON COLUMN weather_consults."time" IS 'data/hora,
retornado pelo webservice.';
COMMENT ON COLUMN weather_consults.wind IS 'vento,
retornado pelo webservice.';
COMMENT ON COLUMN weather_consults.visibility IS 'visibilidade,
retornado pelo webservice.';
COMMENT ON COLUMN weather_consults."skyConditions" IS 'condições do céu,
retornado pelo webservice.';
COMMENT ON COLUMN weather_consults.temperature IS 'temperatura,
retornado pelo webservice.';
COMMENT ON COLUMN weather_consults.windchill IS 'sensação do tempo,
retornado pelo webservice.';
COMMENT ON COLUMN weather_consults."dewPoint" IS 'ponto de orvalho,
retornado pelo webservice.';
COMMENT ON COLUMN weather_consults."relativeHumidity" IS 'humidade relativa do ar,
retornado pelo webservice.';
COMMENT ON COLUMN weather_consults.pressure IS 'pressão,
retornado pelo webservice.';
-------------------------------------------------------------
-- Table: weather_history

-- DROP TABLE weather_history;

CREATE TABLE weather_history
(
  id integer NOT NULL, -- codigo unico e sequencial,...
  "originalDate" time without time zone NOT NULL DEFAULT now(), -- data original do momento da consulta no webservice,...
  country character varying(50) NOT NULL, -- pais,...
  city character varying(80) NOT NULL, -- cidade,...
  location text NOT NULL, -- localização exata da tempo pequisa,...
  "time" timestamp with time zone NOT NULL, -- data/hora,...
  wind text NOT NULL, -- vento,...
  visibility character varying(20) NOT NULL, -- visibilidade,...
  "skyConditions" character varying(15) NOT NULL, -- condições do céu,...
  temperature character varying(15) NOT NULL, -- temperatura,...
  windchill character varying(15) NOT NULL, -- sensação do tempo,...
  "dewPoint" character varying(15) NOT NULL, -- ponto de orvalho,...
  "relativeHumidity" real NOT NULL, -- humidade relativa do ar,...
  pressure real NOT NULL, -- pressão,...
  CONSTRAINT weather_history_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE weather_history
  OWNER TO filipebezerra;
COMMENT ON TABLE weather_history
  IS 'Tabela espelho da tabela "weather_consults" que é responsável por armazenar consistentemente toda informação sem sofrer qualquer alteração.
Esta tabela poderá sofrer somente operação SQL de recuperação (select).';
COMMENT ON COLUMN weather_history.id IS 'codigo unico e sequencial,
gerado automaticamente pelo sgbd.';
COMMENT ON COLUMN weather_history."originalDate" IS 'data original do momento da consulta no webservice,
gerado automaticamente pelo sgbd.';
COMMENT ON COLUMN weather_history.country IS 'pais,
argumento de pesquisa para o webservice.';
COMMENT ON COLUMN weather_history.city IS 'cidade,
argumento de pesquisa para webservice.';
COMMENT ON COLUMN weather_history.location IS 'localização exata da tempo pequisa,
retornado pelo webservice.';
COMMENT ON COLUMN weather_history."time" IS 'data/hora,
retornado pelo webservice.';
COMMENT ON COLUMN weather_history.wind IS 'vento,
retornado pelo webservice.';
COMMENT ON COLUMN weather_history.visibility IS 'visibilidade,
retornado pelo webservice.';
COMMENT ON COLUMN weather_history."skyConditions" IS 'condições do céu,
retornado pelo webservice.';
COMMENT ON COLUMN weather_history.temperature IS 'temperatura,
retornado pelo webservice.';
COMMENT ON COLUMN weather_history.windchill IS 'sensação do tempo,
retornado pelo webservice.';
COMMENT ON COLUMN weather_history."dewPoint" IS 'ponto de orvalho,
retornado pelo webservice.';
COMMENT ON COLUMN weather_history."relativeHumidity" IS 'humidade relativa do ar,
retornado pelo webservice.';
COMMENT ON COLUMN weather_history.pressure IS 'pressão,
retornado pelo webservice.';