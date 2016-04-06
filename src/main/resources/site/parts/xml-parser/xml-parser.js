var portal = require('/lib/xp/portal');
var thymeleaf = require('/lib/xp/thymeleaf');
var xmlParser = require('/lib/xmlParser');
var ioLib = require('/lib/xp/io');

function handleGet(req) {

    var view = resolve('xml-parser.html');

    var res1 = ioLib.getResource('/assets/xml/cars.xml');
    var stream = res1.getStream();
    var xmlAsJson = xmlParser.parse(stream);

    var model = {
        xmlAsJson: xmlAsJson
    };

    log.info("XmlAsJson %s", xmlAsJson);

    return {
        contentType: 'text/html',
        body: thymeleaf.render(view, model)
    };
}

exports.get = handleGet;
