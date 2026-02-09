# Crypto Portfolio Tracker with Risk & Scam Analysis

A comprehensive full-stack application for tracking cryptocurrency holdings, analyzing portfolio risk, detecting potential scams, and making informed investment decisions.

## 🚀 Features

### Core Functionality

- **Portfolio Management** - Track all your crypto holdings across multiple exchanges
- **Trade History** - Record and analyze your complete trading activity
- **Real-time Market Data** - Live cryptocurrency prices and market trends via CoinGecko API
- **Holdings Dashboard** - Visual overview of your portfolio composition and performance
- **Profit/Loss Reports** - Detailed P&L analysis with multiple views and filtering options

### Risk Management

- **Risk Alerts** - Automated alerts for portfolio volatility and price movements
- **Risk Assessment** - AI-powered risk scoring for your holdings
- **Risk Trends** - Historical analysis of portfolio risk metrics
- **Portfolio Rebalancing Suggestions** - Recommendations based on risk profiles

### Scam Detection & Security

- **AI-Powered Scam Analysis** - Intelligent detection of potentially fraudulent coins and tokens
- **Risk Scoring** - Comprehensive risk assessment for each asset
- **Market Sentiment Analysis** - Real-time market sentiment tracking
- **Security Recommendations** - Best practices for secure crypto management

### Exchange Integration

- **Multi-Exchange Support** - Connect to Binance, Kraken, Coinbase, and more
- **Secure Credential Storage** - Encrypted API key management
- **Automated Data Sync** - Periodic updates from connected exchanges
- **Exchange Fee Tracking** - Detailed fee analysis across exchanges

### Notifications & Alerts

- **Price Alerts** - Notifications for significant price movements
- **Trade Confirmations** - Instant notifications for trade execution
- **Risk Alerts** - Proactive warnings for portfolio risk changes
- **In-app Notifications** - Real-time notification center

### User Management

- **Secure Authentication** - JWT-based authentication with email verification
- **Profile Management** - User settings and preferences
- **Password Security** - Secure password reset functionality
- **Session Management** - Secure session handling

## 📋 Tech Stack

### Backend

- **Framework**: Spring Boot 3.5.x
- **Language**: Java 17+
- **Build Tool**: Maven
- **Database**: PostgreSQL/MySQL (configurable)
- **Security**: Spring Security with JWT
- **AI Integration**: OpenAI GPT API for scam detection and analysis
- **Rate Limiting**: Bucket4j for API rate limiting
- **API Documentation**: Swagger/OpenAPI

### Frontend

- **Framework**: React 18.x
- **UI Library**: Tailwind CSS
- **State Management**: Context API
- **HTTP Client**: Axios
- **Charts**: Recharts for data visualization
- **Notifications**: Custom Toast notifications
- **Build Tool**: Create React App / Vite

### External APIs

- **CoinGecko API** - Cryptocurrency market data
- **OpenAI API** - AI-powered scam detection and analysis
- **Exchange APIs** - Binance, Kraken, Coinbase API integrations

## 🛠️ Installation & Setup

### Prerequisites

- Java 17 or higher
- Node.js 16+ and npm
- PostgreSQL/MySQL database
- Git

### Backend Setup

1. **Clone the repository**

```bash
git clone https://github.com/naveenkumareng/Crypto-Portfolio-Tracker-with-Risk-Scam-Analysis.git
cd crypto-portfolio-tracker
```

2. **Configure environment variables**
   Create `backend/src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/crypto_tracker
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

# JWT Configuration
jwt.secret=your_jwt_secret_key_here
jwt.expiration=86400000

# AI Service Configuration
openai.api.key=your_openai_api_key
openai.api.model=gpt-4

# Email Configuration
mail.smtp.host=smtp.gmail.com
mail.smtp.port=587
mail.username=your_email@gmail.com
mail.password=your_app_password
```

3. **Build and run**

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

The backend API will be available at `http://localhost:8080`

### Frontend Setup

1. **Install dependencies**

```bash
cd frontend
npm install
```

2. **Configure API endpoint**
   Create `.env` file in frontend directory:

```
REACT_APP_API_URL=http://localhost:8080/api
```

3. **Start development server**

```bash
npm start
```

The frontend will be available at `http://localhost:3000`

## 📚 API Documentation

### Authentication Endpoints

- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - User login
- `POST /api/auth/forgot-password` - Request password reset
- `POST /api/auth/reset-password` - Reset password

### Portfolio Endpoints

- `GET /api/holdings` - Get all holdings
- `POST /api/holdings` - Add new holding
- `PUT /api/holdings/{id}` - Update holding
- `DELETE /api/holdings/{id}` - Delete holding

### Trade Endpoints

- `GET /api/trades` - Get all trades
- `POST /api/trades` - Add new trade
- `PUT /api/trades/{id}` - Update trade
- `DELETE /api/trades/{id}` - Delete trade

### Exchange Endpoints

- `GET /api/exchanges` - List connected exchanges
- `POST /api/exchanges` - Connect new exchange
- `DELETE /api/exchanges/{id}` - Disconnect exchange

### Risk Analysis

- `GET /api/risk/alerts` - Get active risk alerts
- `GET /api/risk/trends` - Get risk trend data
- `GET /api/risk/assessment` - Get portfolio risk assessment

### AI Scam Detection

- `POST /api/ai/analyze-token` - Analyze token for scam indicators
- `GET /api/ai/risk-report` - Get AI-generated risk report
- `POST /api/ai/ask` - Chat with AI assistant

### Notifications

- `GET /api/notifications` - Get all notifications
- `PUT /api/notifications/{id}/read` - Mark notification as read
- `DELETE /api/notifications/{id}` - Delete notification

## 🔐 Security Features

- **JWT Authentication** - Stateless authentication with JWT tokens
- **Password Encryption** - Bcrypt for secure password storage
- **API Key Encryption** - Secure storage of exchange API credentials
- **CORS Security** - Configured CORS for frontend-backend communication
- **Rate Limiting** - API rate limiting to prevent abuse
- **SQL Injection Prevention** - Parameterized queries via JPA
- **XSS Protection** - Input validation and sanitization

## 📊 Project Structure

```
crypto-portfolio-tracker/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/CryptoProject/CryptoInfosys/
│   │   │   │       ├── config/          # Spring configurations
│   │   │   │       ├── controller/      # REST controllers
│   │   │   │       ├── service/         # Business logic
│   │   │   │       ├── repository/      # Data access layer
│   │   │   │       ├── model/           # Entity classes
│   │   │   │       ├── dto/             # Data transfer objects
│   │   │   │       ├── security/        # Security configurations
│   │   │   │       ├── exception/       # Exception handling
│   │   │   │       └── mapper/          # DTO mappers
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   ├── pom.xml                          # Maven dependencies
│   └── mvnw, mvnw.cmd                  # Maven wrapper
├── frontend/
│   ├── src/
│   │   ├── components/                  # React components
│   │   ├── pages/                       # Page components
│   │   ├── context/                     # Context providers
│   │   ├── api/                         # API client
│   │   ├── App.js                       # Main app component
│   │   └── index.js                     # Entry point
│   ├── public/                          # Static assets
│   ├── package.json                     # NPM dependencies
│   └── tailwind.config.js              # Tailwind configuration
└── README.md                            # Project documentation
```

## 🚀 Deployment

### Backend Deployment

```bash
# Build JAR
mvn clean package

# Deploy to cloud (e.g., Heroku, AWS, Azure)
# Configure environment variables on deployment platform
# Run: java -jar target/CryptoInfosys-0.0.1-SNAPSHOT.jar
```

### Frontend Deployment

```bash
# Build production bundle
npm run build

# Deploy to hosting (e.g., Vercel, Netlify, GitHub Pages)
npm run deploy
```

## 📈 Usage Examples

### Adding a Trade

1. Navigate to "Add Trade"
2. Select exchange and asset
3. Enter trade details (side, quantity, price, fees)
4. Confirm to save

### Viewing Risk Alerts

1. Go to "Risk Alerts" dashboard
2. View active alerts with severity levels
3. Click on alerts for detailed analysis
4. Dismiss or snooze alerts as needed

### Analyzing Potential Scams

1. Use AI Assistant to ask about token legitimacy
2. Get risk scores and detailed analysis
3. View market sentiment and community flags
4. Make informed decisions before investing

### Generating Reports

1. Navigate to "P&L Reports"
2. Select date range and filters
3. View detailed profit/loss calculations
4. Export reports to PDF/Excel

