function updatePaymentFields() {
    // Hide all images initially
    document.querySelectorAll('.wallet-image').forEach(img => img.style.display = 'none');

    // Get selected value
    const selectedBank = document.getElementById('bank').value;

    // Show the corresponding image
    if (selectedBank === 'Zalopay') {
        document.getElementById('zalopay-image').style.display = 'block';
    } else if (selectedBank === 'Momo') {
        document.getElementById('momo-image').style.display = 'block';
    } else if (selectedBank === 'Shopee Pay') {
        document.getElementById('shopee-pay-image').style.display = 'block';
    }

    
    const paymentButton = document.getElementById("payment-confirm-button");

    // Kiểm tra để kích hoạt hoặc vô hiệu hóa nút
    paymentButton.disabled = selectedBank === "Select option";
}

function handlePayment() {
//    alert("Thank you for choosing our services. Your flight itinerary will be sent to your email shortly.");
//    window.location.href = 'index.html'; // Replace 'index.html' with your main page URL
//    
    const selectedBank = document.getElementById('bank').value;

    // Kiểm tra nếu người dùng chưa chọn phương thức thanh toán
    if (selectedBank === "Select option") {
        alert("Please select a payment method.");
        event.preventDefault(); // Ngăn chặn việc gửi biểu mẫu
    } else {
        alert("Thank you for choosing our services. Your flight itinerary will be sent to your email shortly.");
        window.location.href = 'index.html'; // Thay 'index.html' bằng URL trang chính của bạn
    }
}