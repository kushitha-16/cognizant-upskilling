console.log("Welcome to the Community Portal");

// Alert when page loads
function pageLoaded() {
    alert("Welcome to the Local Community Event Portal");

    loadSavedPreference();
    displayEvents();
}

// Event data
let events = [
    {
        name: "Music Night",
        date: "2026-06-10",
        category: "Music",
        seats: 5,
        location: "City Hall"
    },
    {
        name: "Baking Workshop",
        date: "2026-06-15",
        category: "Workshop",
        seats: 3,
        location: "Community Center"
    },
    {
        name: "Sports Day",
        date: "2026-06-20",
        category: "Sports",
        seats: 10,
        location: "Main Ground"
    },
    {
        name: "Career Guidance Seminar",
        date: "2026-06-25",
        category: "Education",
        seats: 8,
        location: "Public Library"
    }
];

// Constructor / class exercise
class CommunityEvent {
    constructor(name, date, category, seats) {
        this.name = name;
        this.date = date;
        this.category = category;
        this.seats = seats;
    }

    checkAvailability() {
        return this.seats > 0;
    }
}

// Add event function
function addEvent(name, date, category, seats, location) {
    events.push({ name, date, category, seats, location });
}

// Display event cards
function displayEvents(eventList = events) {
    const container = document.querySelector("#eventContainer");
    container.innerHTML = "";

    eventList.forEach((event, index) => {
        if (event.seats > 0) {
            const card = document.createElement("div");
            card.className = "eventCard";

            card.innerHTML = `
                <h3>${event.name}</h3>
                <p><strong>Date:</strong> ${event.date}</p>
                <p><strong>Category:</strong> ${event.category}</p>
                <p><strong>Location:</strong> ${event.location}</p>
                <p><strong>Seats:</strong> ${event.seats}</p>
                <button onclick="registerUser(${index})">Register</button>
                <button onclick="cancelRegistration(${index})">Cancel</button>
            `;

            container.appendChild(card);
        }
    });
}

// Registration counter using closure
function createRegistrationTracker() {
    let totalRegistrations = 0;

    return function () {
        totalRegistrations++;
        console.log("Total registrations:", totalRegistrations);
    };
}

const trackRegistration = createRegistrationTracker();

// Register user
function registerUser(index) {
    try {
        if (events[index].seats <= 0) {
            throw new Error("No seats available");
        }

        events[index].seats--;
        trackRegistration();

        alert(`Registered successfully for ${events[index].name}`);
        displayEvents();
    } catch (error) {
        alert(error.message);
    }
}

// Cancel registration
function cancelRegistration(index) {
    events[index].seats++;
    alert("Registration cancelled");
    displayEvents();
}

// Filter events by category
function filterEvents() {
    const category = document.querySelector("#categoryFilter").value;

    const filteredEvents = category === "All"
        ? events
        : events.filter(event => event.category === category);

    displayEvents(filteredEvents);
}

// Search event by name
function searchEvent() {
    const searchText = document.querySelector("#searchBox").value.toLowerCase();

    const searchedEvents = events.filter(event =>
        event.name.toLowerCase().includes(searchText)
    );

    displayEvents(searchedEvents);
}

// Phone validation
function validatePhone() {
    const phone = document.querySelector("#phone").value;

    if (phone.length !== 10 || isNaN(phone)) {
        alert("Please enter a valid 10-digit phone number");
    }
}

// Show event fee
function showEventFee() {
    const eventType = document.querySelector("#eventType").value;
    const feeOutput = document.querySelector("#eventFee");

    let fee = "";

    if (eventType === "Music") {
        fee = "Fee: ₹200";
    } else if (eventType === "Workshop") {
        fee = "Fee: ₹500";
    } else if (eventType === "Sports") {
        fee = "Fee: ₹100";
    } else if (eventType === "Education") {
        fee = "Fee: Free";
    } else {
        fee = "";
    }

    feeOutput.innerText = fee;
}

// Save user preference
function savePreference() {
    const selectedEvent = document.querySelector("#eventType").value;

    localStorage.setItem("preferredEvent", selectedEvent);
    sessionStorage.setItem("sessionEvent", selectedEvent);
}

// Load saved preference
function loadSavedPreference() {
    const savedEvent = localStorage.getItem("preferredEvent");

    if (savedEvent) {
        document.querySelector("#eventType").value = savedEvent;
        showEventFee();
    }
}

// Clear preferences
function clearPreferences() {
    localStorage.clear();
    sessionStorage.clear();

    alert("Preferences cleared");
}

// Form handling
document.querySelector("#registrationForm").addEventListener("submit", function (event) {
    event.preventDefault();

    const form = event.target;

    const name = form.elements["name"].value;
    const email = form.elements["email"].value;
    const eventType = form.elements["eventType"].value;

    if (name === "" || email === "" || eventType === "") {
        document.querySelector("#confirmationMessage").innerText = "Please fill all required fields.";
        document.querySelector("#confirmationMessage").style.color = "red";
        return;
    }

    const userData = {
        name,
        email,
        eventType
    };

    console.log("Submitting registration:", userData);

    // Simulated API POST
    setTimeout(() => {
        fetch("https://jsonplaceholder.typicode.com/posts", {
            method: "POST",
            body: JSON.stringify(userData),
            headers: {
                "Content-type": "application/json"
            }
        })
        .then(response => response.json())
        .then(data => {
            document.querySelector("#confirmationMessage").innerText =
                "Registration submitted successfully!";
            document.querySelector("#confirmationMessage").style.color = "green";
            console.log("Server response:", data);
        })
        .catch(error => {
            document.querySelector("#confirmationMessage").innerText =
                "Registration failed.";
            document.querySelector("#confirmationMessage").style.color = "red";
            console.log(error);
        });
    }, 1000);
});

// Character count
function countCharacters() {
    const text = document.querySelector("#feedbackText").value;
    document.querySelector("#charCount").innerText = text.length;
}

// Double-click image enlarge
function enlargeImage(image) {
    image.style.width = "300px";
    image.style.height = "200px";
}

// Video ready message
function videoReady() {
    document.querySelector("#videoMessage").innerText = "Video ready to play";
}

// Warning before leaving
function warnBeforeLeave() {
    return "Are you sure you want to leave? Your form data may not be saved.";
}

// Geolocation
function findNearbyEvents() {
    const output = document.querySelector("#locationOutput");

    if (!navigator.geolocation) {
        output.innerText = "Geolocation is not supported by this browser.";
        return;
    }

    const options = {
        enableHighAccuracy: true,
        timeout: 5000,
        maximumAge: 0
    };

    navigator.geolocation.getCurrentPosition(
        function (position) {
            output.innerText =
                `Latitude: ${position.coords.latitude}, Longitude: ${position.coords.longitude}`;
        },
        function (error) {
            if (error.code === error.PERMISSION_DENIED) {
                output.innerText = "Permission denied.";
            } else if (error.code === error.TIMEOUT) {
                output.innerText = "Location request timed out.";
            } else {
                output.innerText = "Unable to get location.";
            }
        },
        options
    );
}

// Async / await example
async function fetchMockEvents() {
    try {
        console.log("Loading events...");

        const response = await fetch("https://jsonplaceholder.typicode.com/posts/1");
        const data = await response.json();

        console.log("Mock API data:", data);
    } catch (error) {
        console.log("Error fetching data:", error);
    }
}

fetchMockEvents();

// Object.entries example
const sampleEvent = new CommunityEvent("Health Camp", "2026-06-30", "Education", 20);
console.log(Object.entries(sampleEvent));

// Spread operator example
const clonedEvents = [...events];
console.log("Cloned events:", clonedEvents);

// Map example
const formattedEvents = events.map(event => `Workshop on ${event.name}`);
console.log(formattedEvents);

// jQuery exercise
$(document).ready(function () {
    $("#registerBtn").click(function () {
        $(".eventCard").fadeOut(300).fadeIn(300);
    });
});

// Benefit of frameworks
console.log("Frameworks like React help build reusable components and manage large applications easily.");