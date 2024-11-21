--companies
INSERT IGNORE INTO companies (id, name) VALUES (1, '勤怠株式会社');
INSERT IGNORE INTO companies (id, name) VALUES (2, '株式会社アテンダンス');
INSERT IGNORE INTO companies (id, name) VALUES (3, '株式会社勤怠製作所');
INSERT IGNORE INTO companies (id, name) VALUES (4, 'ヘアサロン　アテンダンス');
INSERT IGNORE INTO companies (id, name) VALUES (5, 'スーパー勤怠　長野店');

--roles
INSERT IGNORE INTO roles (id, name) VALUES (1, 'companyAdmin');
INSERT IGNORE INTO roles (id, name) VALUES (2, 'employee');

--users
INSERT IGNORE INTO users (id, name, telephone, emergency_contact, email, password, role_id, company_id, company_name) VALUES (1, '勤怠 花子', '090-1234-5678', '090-1234-5678', 'hanako.kintai@example.com', 'password', 1, 1, '勤怠株式会社');
INSERT IGNORE INTO users (id, name, telephone, emergency_contact, email, password, role_id, company_id, company_name) VALUES (2, '勤怠 真由美', '090-1234-5678', '090-1234-5678', 'mayumi.kintai@example.com', 'password', 2, 1, '勤怠株式会社');
INSERT IGNORE INTO users (id, name, telephone, emergency_contact, email, password, role_id, company_id, company_name) VALUES (3, '勤怠 太郎', '090-1234-5678', '090-1234-5678', 'taro.kintai@example.com', 'password', 1, 2, '株式会社アテンダンス');
INSERT IGNORE INTO users (id, name, telephone, emergency_contact, email, password, role_id, company_id, company_name) VALUES (4, '勤怠 次郎', '090-1234-5678', '090-1234-5678', 'jiro.kintai@example.com', 'password', 2, 3, '株式会社勤怠製作所');
INSERT IGNORE INTO users (id, name, telephone, emergency_contact, email, password, role_id, company_id, company_name) VALUES (5, '勤怠 祐子', '090-1234-5678', '090-1234-5678', 'yuko.kintai@example.com', 'password', 2, 4, 'ヘアサロン　アテンダンス');