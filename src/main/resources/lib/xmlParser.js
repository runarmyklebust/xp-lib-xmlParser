var bean = __.newBean('com.enonic.xp.sample.xmlparser.XmlParser');

exports.parse = function (stream) {
    var result = bean.parse(stream);
    return __.toNativeObject(result);
};
