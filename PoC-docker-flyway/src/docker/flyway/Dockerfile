FROM dhoer/flyway:alpine
COPY ./sql/*.sql /flyway/sql

ADD ./wait-for-it.sh /
RUN chmod 777 /wait-for-it.sh
