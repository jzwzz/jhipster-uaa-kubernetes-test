var StorageMock = function () {
    var store = {};
    return {
        getItem: function (key) { return store[key] || null; },
        setItem: function (key, value) { return (store[key] = value.toString()); },
        clear: function () { return (store = {}); }
    };
};
Object.defineProperty(window, 'localStorage', {
    value: StorageMock()
});
Object.defineProperty(window, 'sessionStorage', {
    value: StorageMock()
});
