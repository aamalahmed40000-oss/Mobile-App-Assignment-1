// ===== TURBOTICRESPONSIVE – Hamburger Menu =====
document.addEventListener('DOMContentLoaded', function () {

  var toggle = document.querySelector('.menu-toggle');

  // --- Pages that use .nav-links (Home, Car, rent, Motorcycle) ---
  var navLinks = document.querySelector('.nav-links');

  // --- confrom.html uses nav > ul ---
  var navUL = document.querySelector('nav ul');

  if (toggle) {
    toggle.addEventListener('click', function (e) {
      e.stopPropagation();

      if (navLinks) {
        navLinks.classList.toggle('active');
      }
      if (navUL) {
        navUL.classList.toggle('active');
      }

      // Swap icon bars ↔ xmark
      var icon = toggle.querySelector('i');
      if (icon) {
        icon.classList.toggle('fa-bars');
        icon.classList.toggle('fa-xmark');
      }
    });

    // Close when clicking any nav link
    var allLinks = document.querySelectorAll('.nav-links a, nav ul a');
    allLinks.forEach(function (link) {
      link.addEventListener('click', function () {
        if (navLinks)  navLinks.classList.remove('active');
        if (navUL)     navUL.classList.remove('active');
        var icon = toggle.querySelector('i');
        if (icon) { icon.classList.add('fa-bars'); icon.classList.remove('fa-xmark'); }
      });
    });

    // Close when clicking outside
    document.addEventListener('click', function (e) {
      if (!toggle.contains(e.target) &&
          (!navLinks || !navLinks.contains(e.target)) &&
          (!navUL    || !navUL.contains(e.target))) {
        if (navLinks)  navLinks.classList.remove('active');
        if (navUL)     navUL.classList.remove('active');
        var icon = toggle.querySelector('i');
        if (icon) { icon.classList.add('fa-bars'); icon.classList.remove('fa-xmark'); }
      }
    });
  }

});
