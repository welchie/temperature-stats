FROM postgres:12.2

ENV POSTGRES_PASSWORD=postgres
ENV POSTGRES_USER=postgres
ENV POSTGRES_DB=temperature_stats

COPY files/create_db.sql /docker-entrypoint-initdb.d/create_db.sql 
