# IQVIA_CODETEST
Back-end home challenge
- Project is based on sprintboog3.0.1, maven packages with Quartz and Jpa. Use mysql database.
- Database table will be auto-generated.
- change spring.quartz.jdbc.initialize-schema=always when first install with database, for Quartz only. or use /doc/Quartzinit.sql for initialization. (for Tag autoconfig_5H)
- Quartz tables should be import into database manually, script could be found at <a href="https://github.com/tabtu/IQVIA_CODETEST/blob/master/doc/QuartzInit.sql">QuartzInit.sql</a>
- Please use mvn command to run the springboot app.
- end points are /putmessage and /postmessage
- get method to /example to get the model schema
- {"schedule_time": "2022-12-31 12:31", "message_content": "HELLO: IQVIA"}
****

## IDEAS
- new message will be add into database.
- existed message will not be saved duplicate.
- Quartz tables will be started with 'IQVIA_QRTZ_'.
- separate main database and quartz tables.
- support distributed configuration.
****

## LINKS
- requirement (<a href="https://github.com/tabtu/IQVIA_CODETEST/blob/master/doc/Requirements.html">/doc/Requirements.html</a>)
- work break down and time log script (<a href="https://github.com/tabtu/IQVIA_CODETEST/blob/master/doc/WBS.txt">/doc/WBS.txt</a>)
- Quartz initialization script(<a href="https://github.com/tabtu/IQVIA_CODETEST/blob/tab/doc/QuartzInit_SequelAce.sql">/doc/QuartzInit_SequelAce.sql</a> or <a href="https://github.com/tabtu/IQVIA_CODETEST/blob/tab/doc/QuartzInit_Navcat.sql">/doc/QuartzInit_Navcat.sql</a>). Exported from different database tool but same schema. 

****


## Requirements

<html xmlns:o='urn:schemas-microsoft-com:office:office'
      xmlns:w='urn:schemas-microsoft-com:office:word'
      xmlns:v='urn:schemas-microsoft-com:vml'
      xmlns='urn:w3-org-ns:HTML'>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Backend home challenge</title>
    <!--[if gte mso 9]>
    <xml>
        <o:OfficeDocumentSettings>
            <o:TargetScreenSize>1024x640</o:TargetScreenSize>
            <o:PixelsPerInch>72</o:PixelsPerInch>
            <o:AllowPNG/>
        </o:OfficeDocumentSettings>
        <w:WordDocument>
            <w:View>Print</w:View>
            <w:Zoom>90</w:Zoom>
            <w:DoNotOptimizeForBrowser/>
        </w:WordDocument>
    </xml>
    <![endif]-->
    <style>
                <!--
        @page Section1 {
            size: 8.5in 11.0in;
            margin: 1.0in;
            mso-header-margin: .5in;
            mso-footer-margin: .5in;
            mso-paper-source: 0;
        }

        table {
            border: solid 1px;
            border-collapse: collapse;
        }

        table td, table th {
            border: solid 1px;
            padding: 5px;
        }

        td {
            page-break-inside: avoid;
        }

        tr {
            page-break-after: avoid;
        }

        div.Section1 {
            page: Section1;
        }

        /* Confluence print stylesheet. Common to all themes for print media */
/* Full of !important until we improve batching for print CSS */

@media print {
    #main {
        padding-bottom: 1em !important; /* The default padding of 6em is too much for printouts */
    }

    body {
        font-family: Arial, Helvetica, FreeSans, sans-serif;
        font-size: 10pt;
        line-height: 1.2;
    }

    body, #full-height-container, #main, #page, #content, .has-personal-sidebar #content {
        background: #fff !important;
        color: #000 !important;
        border: 0 !important;
        width: 100% !important;
        height: auto !important;
        min-height: auto !important;
        margin: 0 !important;
        padding: 0 !important;
        display: block !important;
    }

    a, a:link, a:visited, a:focus, a:hover, a:active {
        color: #000;
    }

    #content h1,
    #content h2,
    #content h3,
    #content h4,
    #content h5,
    #content h6 {
        font-family: Arial, Helvetica, FreeSans, sans-serif;
        page-break-after: avoid;
    }

    pre {
        font-family: Monaco, "Courier New", monospace;
    }

    #header,
    .aui-header-inner,
    #navigation,
    #sidebar,
    .sidebar,
    #personal-info-sidebar,
    .ia-fixed-sidebar,
    .page-actions,
    .navmenu,
    .ajs-menu-bar,
    .noprint,
    .inline-control-link,
    .inline-control-link a,
    a.show-labels-editor,
    .global-comment-actions,
    .comment-actions,
    .quick-comment-container,
    #addcomment {
        display: none !important;
    }

    /* CONF-28544 cannot print multiple pages in IE */
    #splitter-content {
        position: relative !important;
    }

    .comment .date::before {
        content: none !important; /* remove middot for print view */
    }

    h1.pagetitle img {
        height: auto;
        width: auto;
    }

    .print-only {
        display: block;
    }

    #footer {
        position: relative !important; /* CONF-17506 Place the footer at end of the content */
        margin: 0;
        padding: 0;
        background: none;
        clear: both;
    }

    #poweredby {
        border-top: none;
        background: none;
    }

    #poweredby li.print-only {
        display: list-item;
        font-style: italic;
    }

    #poweredby li.noprint {
        display: none;
    }

    /* no width controls in print */
    .wiki-content .table-wrap,
    .wiki-content p,
    .panel .codeContent,
    .panel .codeContent pre,
    .image-wrap {
        overflow: visible !important;
    }

    /* TODO - should this work? */
    #children-section,
    #comments-section .comment,
    #comments-section .comment .comment-body,
    #comments-section .comment .comment-content,
    #comments-section .comment p {
        page-break-inside: avoid;
    }

    #page-children a {
        text-decoration: none;
    }

    /**
     hide twixies
     the specificity here is a hack because print styles
     are getting loaded before the base styles. */
    #comments-section.pageSection .section-header,
    #comments-section.pageSection .section-title,
    #children-section.pageSection .section-header,
    #children-section.pageSection .section-title,
    .children-show-hide {
        padding-left: 0;
        margin-left: 0;
    }

    .children-show-hide.icon {
        display: none;
    }

    /* personal sidebar */
    .has-personal-sidebar #content {
        margin-right: 0px;
    }

    .has-personal-sidebar #content .pageSection {
        margin-right: 0px;
    }

    .no-print, .no-print * {
        display: none !important;
    }
}
-->
    </style>
</head>
<body>
    <h1>Backend home challenge</h1>
    <div class="Section1">
        <h2 id="Backendhomechallenge-Problemdescription"><span>Problem description</span></h2>
<p><span>Write a RESTful web service that schedules messages to be printed. The web service should accept a message content and delivery time. The web service should return 202 status code (accepted) if the message was successfully scheduled. The web service should print the message content on the console at the delivery time specified. The system should recover and messages should not be lost in case of restart.</span></p>
<h3 id="Backendhomechallenge-Technicalconstraints"><span>Technical constraints</span></h3>
<p><span>Keep the solution simple, you must use spring boot and its libraries (rest, data ...etc) as much as you can. You can use other libraries as long as they don't have a parallel in spring boot.</span></p>
<h3 id="Backendhomechallenge-Whatarewelookingfor:"><span>What are we looking for:</span></h3>
<ol>
<li><span>A working solution.</span></li>
<li><span>Code quality (organization, modularity, modeling, testing ...etc).</span></li>
<li><span>Your ability to follow instructions.</span></li>
<li><span>Well documented code.</span></li>
<li><span>Clearly defined models.</span></li>
<li><span>RESTful design.</span></li>
<li><span>Database of your choice.</span></li>
<li><span>Unit tests</span></li>
</ol>
<h3 id="Backendhomechallenge-Submission"><span>Submission</span></h3>
<p><span>We understand that people are busy, the above assignment should take ~8 hours of straight programming if you built a similar solution before, feel free to break those 8 hours apart over a reasonable number of days. After you read the problem description, you need to let us know how long it would take you to have a working solution and when are you planning to send it to us. The solution must be saved in a private git repository. The git repository readme file should include information about how to build and run the application.</span></p>
    </div>
</body>
</html>