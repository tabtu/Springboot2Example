# IQVIA_CODETEST
Back-end home challenge
- Project is based on sprintboog2.7.7, maven packages with Quartz and Jpa. Use mysql database.
- Database table will be auto-generated.
- change spring.quartz.jdbc.initialize-schema=always when first install with database, for Quartz only. or use /doc/Quartzinit.sql for initialization.
- Please use mvn command to run the springboot app.
- end points are /putmessage and /postmessage
- get method to /example to get the model schema
- {"schedule_time": "2022-12-31 12:31", "message_content": "HELLO: IQVIA"}
****

## IDEAS
- new message will be add into database.
- existed message will not be saved duplicate.
- Quartz tables will be started with 'QRTZ'.
****

## LINKS
- requirement (<a href="https://github.com/tabtu/IQVIA_CODETEST/doc/Requirements.html">/doc/Requirements.html</a>)
- work break down and time log script (<a href="https://github.com/tabtu/IQVIA_CODETEST/doc/WBS.txt">/doc/WBS.txt</a>)
- Quartz initialization script(<a href="https://github.com/tabtu/IQVIA_CODETEST/doc/Quartzinit.sql">/doc/WBS.txt</a>)


