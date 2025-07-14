class Car {
  constructor(type, ratePerKm) {
    this.type = type;
    this.ratePerKm = ratePerKm;
    this.baseFare = 50; // Default base fare
  }

  getSurgeAndBase(hour) {
    if (hour >= 22 || hour < 6) {
      return { surge: 1.3, base: this.baseFare + 60 }; // Night
    } else if (hour >= 18 && hour < 22) {
      return { surge: 1.2, base: this.baseFare }; // Evening
    }
    return { surge: 1.0, base: this.baseFare }; // Day
  }

  getOutstationExtraPerKm(km) {
    if (km > 200) return 4;
    if (km > 100) return 2;
    return 0;
  }

  calculateFare(km, hour) {
    const { surge, base } = this.getSurgeAndBase(hour);
    const extraPerKm = this.getOutstationExtraPerKm(km);
    const totalRate = this.ratePerKm + extraPerKm;
    const fare = (base + km * totalRate) * surge;
    return fare.toFixed(2);
  }
}

const cars = [
  new Car('Uber', 10),
  new Car('XL', 15),
  new Car('Sedan', 12)
];

function showPrices() {
  const kmInput = document.getElementById('kmInput');
  const priceList = document.getElementById('priceList');
  const finalPriceDiv = document.getElementById('finalPrice');
  const km = parseFloat(kmInput.value);

  if (isNaN(km) || km <= 0) {
    alert("Please enter a valid distance in kilometers.");
    return;
  }

  // Get current IST time
  const indianTimeStr = new Date().toLocaleString("en-US", { timeZone: "Asia/Kolkata" });
  const hour = new Date(indianTimeStr).getHours();
  const displayTime = new Date(indianTimeStr).toLocaleTimeString('en-IN', { hour12: true });
  document.getElementById('timeNow').textContent = `Current Time (India): ${displayTime}`;

  priceList.innerHTML = '';
  finalPriceDiv.innerHTML = '';

  cars.forEach(car => {
    const fare = car.calculateFare(km, hour);
    const card = document.createElement('div');
    card.className = 'car-card';

    card.innerHTML = `
      <span><strong>${car.type}</strong>: ₹${fare}</span>
      <button onclick="selectCar('${car.type}', ${fare})">Select</button>
    `;

    priceList.appendChild(card);
  });
}

function selectCar(type, fare) {
  document.getElementById('finalPrice').textContent = `You selected ${type}. Final Price: ₹${fare}`;
}
