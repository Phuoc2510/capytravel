window.onscroll = function () {
    var navbar = document.getElementsByClassName("header-container");
    if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
        navbar.classList.add("scrolled");
    } else {
        navbar.classList.remove("scrolled");
    }
};



//form search không cho chung địa điểm
function searchFlights() {
    const departure = document.getElementById('departure').value;
    const destination = document.getElementById('destination').value;

    if (departure === destination) {
        alert('Departure and destination cannot be the same!');
    }

}

// Sticky Header
    const header = document.querySelector(".header");

    window.addEventListener("scroll", () => {
        if (window.isHomePage) {
            if (window.pageYOffset > 50) {
                header.classList.add("active");
            } else {
                header.classList.remove("active");
            }
        } else {
            // Thêm active cho các trang không phải home
            header.classList.add("active");
        }
    });
    // Khởi tạo trạng thái ban đầu cho header
    if (!window.isHomePage) {
        header.classList.add("active"); // Đảm bảo header có lớp active ngay từ đầu
    }


// Định dạng ngày
const today = new Date(); // Lấy ngày hiện tại
const returnDate = new Date(); // Ngày hiện tại
returnDate.setDate(today.getDate() + 2); // Cộng thêm 2 ngày

const options = {
    dateFormat: "M j, Y", // Định dạng ngày
};

flatpickr("#departure-date", {
    ...options,
    defaultDate: today, // Ngày mặc định là ngày hiện tại
});

const fpReturnDate = flatpickr("#return-date", {
    ...options,
    defaultDate: returnDate, // Ngày mặc định là ngày hiện tại + 2 ngày
    inline: false, // Không hiển thị lịch ngay
});


// Lúc đầu Icon Return Date màu đen, bắt sk click 2 lần

let clickCount = 0;

const inputDark = document.querySelector(".schedule__input-2");
const iconReturnDate = document.querySelector("label[for='return-date']").nextElementSibling;

if (inputDark && iconReturnDate) {
    if (inputDark.classList.contains("dark")) {
        iconReturnDate.style.color = 'rgba(0, 0, 0, 0.3)';
    }

    const handleClick = () => {
        clickCount++;
        if (clickCount === 1) {
            inputDark.classList.remove("dark");
            iconReturnDate.style.color = "#0099CC";
        } else if (clickCount === 2) {
            fpReturnDate.open();
            clickCount = 0;
        }
    };

    iconReturnDate.addEventListener("click", handleClick);

    inputDark.addEventListener("click", (event) => {
        event.preventDefault();
        event.stopPropagation();
        handleClick();
    });

}

// js profile

function toggleDropdown() {
    const dropdown = document.getElementById("dropdownMenu");
    if (dropdown.style.display === "none" || dropdown.style.display === "") {
        dropdown.style.display = "block";
    } else {
        dropdown.style.display = "none";
    }
}

// Đóng menu khi nhấp ra ngoài
window.onclick = function (event) {
    const dropdown = document.getElementById("dropdownMenu");
    if (!event.target.matches('.user-icon')) {
        if (dropdown.style.display === "block") {
            dropdown.style.display = "none";
        }
    }
}

function scrollToSection(section) {
    // Prevent the default link behavior
    event.preventDefault();

    // Scroll to the specified section
    var targetElement = document.getElementById(section);
    if (targetElement) {
        targetElement.scrollIntoView({behavior: "smooth"});
    }
}

    // This function handles the navigation to Help Center
    function navigateToHelpCenter(event) {
        event.preventDefault(); // Prevent the default link behavior
        window.location.href = '/CapyTravel/helpcenter.jsp';  // Navigate to the Help Center without showing the full URL
    }