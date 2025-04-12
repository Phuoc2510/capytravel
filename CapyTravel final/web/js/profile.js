
function previewImage(event) {
    const file = event.target.files[0];
    if (!file) {
        console.log("No file selected");
        return; // Không có file nào ???c ch?n
    }

    const reader = new FileReader();
    reader.onload = function () {
        const output = document.getElementById('avatarPreview');
        output.src = reader.result; // C?p nh?t ?nh xem tr??c
        console.log("Image preview updated");
    };
    reader.onerror = function () {
        console.error("Error reading file");
    };
    reader.readAsDataURL(file); // ??c file và t?o URL
}

function resetInput() {
    // C?p nh?t selector ?? ch?n l?p "avatar-image"
    const fileInput = document.querySelector('.avatar-image');
    fileInput.value = ''; // Xóa file ?ã ch?n
    document.getElementById('avatarPreview').src = "<%= request.getContextPath()%>/imgs/Avatar/${requestScope.SEARCH_USER.avatar}"; // Khôi ph?c ?nh m?c ??nh
    console.log("Input reset and default image restored");
}

