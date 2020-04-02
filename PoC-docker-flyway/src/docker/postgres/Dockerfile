FROM postgres:9.4-alpine

RUN mkdir -p /initdb
ADD db_startup.sql /home/db_startup.sql

ADD db-init.sh /initdb/
RUN dos2unix /initdb/db-init.sh
RUN chmod 755 /initdb/db-init.sh
