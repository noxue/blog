// pangu.js:等库加载后自动为全文中英文/数字之间加空格
(function () {
  function run() {
    if (window.pangu) {
      try { pangu.spacingPageBody(); } catch (e) {}
    } else {
      setTimeout(run, 200);
    }
  }
  if (document.readyState === "loading") {
    document.addEventListener("DOMContentLoaded", run);
  } else {
    run();
  }
})();
