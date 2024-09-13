var ge = Object.defineProperty;
var ve = (t, e, n) => e in t ? ge(t, e, {enumerable: !0, configurable: !0, writable: !0, value: n}) : t[e] = n;
var z = (t, e, n) => ve(t, typeof e != "symbol" ? e + "" : e, n);
(function () {
    const e = document.createElement("link").relList;
    if (e && e.supports && e.supports("modulepreload")) return;
    for (const l of document.querySelectorAll('link[rel="modulepreload"]')) o(l);
    new MutationObserver(l => {
        for (const u of l) if (u.type === "childList") for (const i of u.addedNodes) i.tagName === "LINK" && i.rel === "modulepreload" && o(i)
    }).observe(document, {childList: !0, subtree: !0});

    function n(l) {
        const u = {};
        return l.integrity && (u.integrity = l.integrity), l.referrerPolicy && (u.referrerPolicy = l.referrerPolicy), l.crossOrigin === "use-credentials" ? u.credentials = "include" : l.crossOrigin === "anonymous" ? u.credentials = "omit" : u.credentials = "same-origin", u
    }

    function o(l) {
        if (l.ep) return;
        l.ep = !0;
        const u = n(l);
        fetch(l.href, u)
    }
})();

function k() {
}

function he(t) {
    return t()
}

function le() {
    return Object.create(null)
}

function S(t) {
    t.forEach(he)
}

function _e(t) {
    return typeof t == "function"
}

function D(t, e) {
    return t != t ? e == e : t !== e || t && typeof t == "object" || typeof t == "function"
}

function be(t) {
    return Object.keys(t).length === 0
}

function f(t, e) {
    t.appendChild(e)
}

function C(t, e, n) {
    t.insertBefore(e, n || null)
}

function O(t) {
    t.parentNode && t.parentNode.removeChild(t)
}

function Z(t, e) {
    for (let n = 0; n < t.length; n += 1) t[n] && t[n].d(e)
}

function _(t) {
    return document.createElement(t)
}

function M(t) {
    return document.createTextNode(t)
}

function g() {
    return M(" ")
}

function w(t, e, n, o) {
    return t.addEventListener(e, n, o), () => t.removeEventListener(e, n, o)
}

function q(t, e, n) {
    n == null ? t.removeAttribute(e) : t.getAttribute(e) !== n && t.setAttribute(e, n)
}

function $e(t) {
    let e;
    return {
        p(...n) {
            e = n, e.forEach(o => t.push(o))
        }, r() {
            e.forEach(n => t.splice(t.indexOf(n), 1))
        }
    }
}

function ye(t) {
    return Array.from(t.childNodes)
}

function x(t, e) {
    e = "" + e, t.data !== e && (t.data = e)
}

function b(t, e) {
    t.value = e ?? ""
}

let ee;

function L(t) {
    ee = t
}

const j = [], re = [];
let I = [];
const ie = [], Oe = Promise.resolve();
let X = !1;

function we() {
    X || (X = !0, Oe.then(me))
}

function Y(t) {
    I.push(t)
}

const G = new Set;
let N = 0;

function me() {
    if (N !== 0) return;
    const t = ee;
    do {
        try {
            for (; N < j.length;) {
                const e = j[N];
                N++, L(e), Ce(e.$$)
            }
        } catch (e) {
            throw j.length = 0, N = 0, e
        }
        for (L(null), j.length = 0, N = 0; re.length;) re.pop()();
        for (let e = 0; e < I.length; e += 1) {
            const n = I[e];
            G.has(n) || (G.add(n), n())
        }
        I.length = 0
    } while (j.length);
    for (; ie.length;) ie.pop()();
    X = !1, G.clear(), L(t)
}

function Ce(t) {
    if (t.fragment !== null) {
        t.update(), S(t.before_update);
        const e = t.dirty;
        t.dirty = [-1], t.fragment && t.fragment.p(t.ctx, e), t.after_update.forEach(Y)
    }
}

function ke(t) {
    const e = [], n = [];
    I.forEach(o => t.indexOf(o) === -1 ? e.push(o) : n.push(o)), n.forEach(o => o()), I = e
}

const T = new Set;
let Pe;

function F(t, e) {
    t && t.i && (T.delete(t), t.i(e))
}

function H(t, e, n, o) {
    if (t && t.o) {
        if (T.has(t)) return;
        T.add(t), Pe.c.push(() => {
            T.delete(t)
        }), t.o(e)
    }
}

function U(t) {
    return (t == null ? void 0 : t.length) !== void 0 ? t : Array.from(t)
}

function W(t) {
    t && t.c()
}

function B(t, e, n) {
    const {fragment: o, after_update: l} = t.$$;
    o && o.m(e, n), Y(() => {
        const u = t.$$.on_mount.map(he).filter(_e);
        t.$$.on_destroy ? t.$$.on_destroy.push(...u) : S(u), t.$$.on_mount = []
    }), l.forEach(Y)
}

function J(t, e) {
    const n = t.$$;
    n.fragment !== null && (ke(n.after_update), S(n.on_destroy), n.fragment && n.fragment.d(e), n.on_destroy = n.fragment = null, n.ctx = [])
}

function qe(t, e) {
    t.$$.dirty[0] === -1 && (j.push(t), we(), t.$$.dirty.fill(0)), t.$$.dirty[e / 31 | 0] |= 1 << e % 31
}

function Q(t, e, n, o, l, u, i = null, h = [-1]) {
    const p = ee;
    L(t);
    const c = t.$$ = {
        fragment: null,
        ctx: [],
        props: u,
        update: k,
        not_equal: l,
        bound: le(),
        on_mount: [],
        on_destroy: [],
        on_disconnect: [],
        before_update: [],
        after_update: [],
        context: new Map(e.context || (p ? p.$$.context : [])),
        callbacks: le(),
        dirty: h,
        skip_bound: !1,
        root: e.target || p.$$.root
    };
    i && i(c.root);
    let a = !1;
    if (c.ctx = n ? n(t, e.props || {}, (r, s, ...d) => {
        const y = d.length ? d[0] : s;
        return c.ctx && l(c.ctx[r], c.ctx[r] = y) && (!c.skip_bound && c.bound[r] && c.bound[r](y), a && qe(t, r)), s
    }) : [], c.update(), a = !0, S(c.before_update), c.fragment = o ? o(c.ctx) : !1, e.target) {
        if (e.hydrate) {
            const r = ye(e.target);
            c.fragment && c.fragment.l(r), r.forEach(O)
        } else c.fragment && c.fragment.c();
        e.intro && F(t.$$.fragment), B(t, e.target, e.anchor), me()
    }
    L(p)
}

class K {
    constructor() {
        z(this, "$$");
        z(this, "$$set")
    }

    $destroy() {
        J(this, 1), this.$destroy = k
    }

    $on(e, n) {
        if (!_e(n)) return k;
        const o = this.$$.callbacks[e] || (this.$$.callbacks[e] = []);
        return o.push(n), () => {
            const l = o.indexOf(n);
            l !== -1 && o.splice(l, 1)
        }
    }

    $set(e) {
        this.$$set && !be(e) && (this.$$.skip_bound = !0, this.$$set(e), this.$$.skip_bound = !1)
    }
}

const Ee = "4";
typeof window < "u" && (window.__svelte || (window.__svelte = {v: new Set})).v.add(Ee);

function Se(t) {
    let e, n, o, l, u, i, h, p, c, a;
    return {
        c() {
            e = _("div"), n = _("h2"), n.textContent = "Create User", o = g(), l = _("input"), u = g(), i = _("input"), h = g(), p = _("button"), p.textContent = "Create User", q(l, "placeholder", "Username"), q(i, "placeholder", "Email"), q(i, "type", "email")
        }, m(r, s) {
            C(r, e, s), f(e, n), f(e, o), f(e, l), b(l, t[0].username), f(e, u), f(e, i), b(i, t[0].email), f(e, h), f(e, p), c || (a = [w(l, "input", t[2]), w(i, "input", t[3]), w(p, "click", t[1])], c = !0)
        }, p(r, [s]) {
            s & 1 && l.value !== r[0].username && b(l, r[0].username), s & 1 && i.value !== r[0].email && b(i, r[0].email)
        }, i: k, o: k, d(r) {
            r && O(e), c = !1, S(a)
        }
    }
}

function Ae(t, e, n) {
    let o = {username: "", email: ""};
    const l = async () => {
        try {
            const h = await fetch("http://localhost:8080/users", {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(o)
            });
            h.ok ? (console.log("User created:", await h.json()), n(0, o.username = "", o), n(0, o.email = "", o)) : console.error("Failed to create user")
        } catch (h) {
            console.error("Error:", h)
        }
    };

    function u() {
        o.username = this.value, n(0, o)
    }

    function i() {
        o.email = this.value, n(0, o)
    }

    return [o, l, u, i]
}

class Ne extends K {
    constructor(e) {
        super(), Q(this, e, Ae, Se, D, {})
    }
}

function ue(t, e, n) {
    const o = t.slice();
    return o[8] = e[n], o
}

function se(t, e, n) {
    const o = t.slice();
    return o[11] = e[n], o[12] = e, o[13] = n, o
}

function ce(t) {
    let e, n, o;

    function l() {
        t[6].call(e, t[13], t[12])
    }

    return {
        c() {
            e = _("input"), q(e, "placeholder", "Vote Option Caption")
        }, m(u, i) {
            C(u, e, i), b(e, t[11][t[13]].caption), n || (o = w(e, "input", l), n = !0)
        }, p(u, i) {
            t = u, i & 1 && e.value !== t[11][t[13]].caption && b(e, t[11][t[13]].caption)
        }, d(u) {
            u && O(e), n = !1, o()
        }
    }
}

function je(t) {
    let e;
    return {
        c() {
            e = _("p"), e.textContent = "No available polls."
        }, m(n, o) {
            C(n, e, o)
        }, p: k, d(n) {
            n && O(e)
        }
    }
}

function Ie(t) {
    let e, n = U(t[1]), o = [];
    for (let l = 0; l < n.length; l += 1) o[l] = ae(ue(t, n, l));
    return {
        c() {
            e = _("ul");
            for (let l = 0; l < o.length; l += 1) o[l].c()
        }, m(l, u) {
            C(l, e, u);
            for (let i = 0; i < o.length; i += 1) o[i] && o[i].m(e, null)
        }, p(l, u) {
            if (u & 2) {
                n = U(l[1]);
                let i;
                for (i = 0; i < n.length; i += 1) {
                    const h = ue(l, n, i);
                    o[i] ? o[i].p(h, u) : (o[i] = ae(h), o[i].c(), o[i].m(e, null))
                }
                for (; i < o.length; i += 1) o[i].d(1);
                o.length = n.length
            }
        }, d(l) {
            l && O(e), Z(o, l)
        }
    }
}

function ae(t) {
    let e, n = t[8].question + "", o;
    return {
        c() {
            e = _("li"), o = M(n)
        }, m(l, u) {
            C(l, e, u), f(e, o)
        }, p(l, u) {
            u & 2 && n !== (n = l[8].question + "") && x(o, n)
        }, d(l) {
            l && O(e)
        }
    }
}

function Ue(t) {
    let e, n, o, l, u, i, h, p, c, a, r, s, d, y, R, te, A = U(t[0].voteOptions), $ = [];
    for (let m = 0; m < A.length; m += 1) $[m] = ce(se(t, A, m));

    function ne(m, E) {
        return m[1].length > 0 ? Ie : je
    }

    let V = ne(t), P = V(t);
    return {
        c() {
            e = _("div"), n = _("h2"), n.textContent = "Create Poll", o = g(), l = _("input"), u = g(), i = _("input"), h = g();
            for (let m = 0; m < $.length; m += 1) $[m].c();
            p = g(), c = _("button"), c.textContent = "Add Vote Option", a = g(), r = _("button"), r.textContent = "Create Poll", s = g(), d = _("h3"), d.textContent = "Available Polls", y = g(), P.c(), q(l, "placeholder", "Username"), q(i, "placeholder", "Question")
        }, m(m, E) {
            C(m, e, E), f(e, n), f(e, o), f(e, l), b(l, t[0].username), f(e, u), f(e, i), b(i, t[0].question), f(e, h);
            for (let v = 0; v < $.length; v += 1) $[v] && $[v].m(e, null);
            f(e, p), f(e, c), f(e, a), f(e, r), f(e, s), f(e, d), f(e, y), P.m(e, null), R || (te = [w(l, "input", t[4]), w(i, "input", t[5]), w(c, "click", t[2]), w(r, "click", t[3])], R = !0)
        }, p(m, [E]) {
            if (E & 1 && l.value !== m[0].username && b(l, m[0].username), E & 1 && i.value !== m[0].question && b(i, m[0].question), E & 1) {
                A = U(m[0].voteOptions);
                let v;
                for (v = 0; v < A.length; v += 1) {
                    const oe = se(m, A, v);
                    $[v] ? $[v].p(oe, E) : ($[v] = ce(oe), $[v].c(), $[v].m(e, p))
                }
                for (; v < $.length; v += 1) $[v].d(1);
                $.length = A.length
            }
            V === (V = ne(m)) && P ? P.p(m, E) : (P.d(1), P = V(m), P && (P.c(), P.m(e, null)))
        }, i: k, o: k, d(m) {
            m && O(e), Z($, m), P.d(), R = !1, S(te)
        }
    }
}

function Le(t, e, n) {
    let o = {
        pollId: "",
        username: "",
        question: "",
        publishedAt: new Date().toISOString(),
        validUntil: "",
        voteOptions: []
    }, l = [];

    async function u() {
        try {
            const r = await fetch("http://localhost:8080/polls");
            r.ok ? n(1, l = await r.json()) : console.error("Failed to load available polls")
        } catch (r) {
            console.error("Error:", r)
        }
    }

    const i = () => {
        n(0, o.voteOptions = [...o.voteOptions, {caption: "", presentationOrder: o.voteOptions.length}], o)
    }, h = async () => {
        try {
            const r = await fetch("http://localhost:8080/polls", {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(o)
            });
            if (r.ok) {
                const s = await r.json();
                console.log("Poll created:", s), n(1, l = [...l, s]), n(0, o = {
                    pollId: "",
                    username: "",
                    question: "",
                    publishedAt: new Date().toISOString(),
                    validUntil: "",
                    voteOptions: []
                })
            } else console.error("Failed to create poll")
        } catch (r) {
            console.error("Error:", r)
        }
    };
    u();

    function p() {
        o.username = this.value, n(0, o)
    }

    function c() {
        o.question = this.value, n(0, o)
    }

    function a(r, s) {
        s[r][r].caption = this.value, n(0, o)
    }

    return [o, l, i, h, p, c, a]
}

class Ve extends K {
    constructor(e) {
        super(), Q(this, e, Le, Ue, D, {})
    }
}

function fe(t, e, n) {
    const o = t.slice();
    return o[8] = e[n], o
}

function pe(t) {
    let e, n = t[0].poll.question + "", o, l, u, i, h, p, c = U(t[0].poll.voteOptions), a = [];
    for (let r = 0; r < c.length; r += 1) a[r] = de(fe(t, c, r));
    return {
        c() {
            e = _("h3"), o = M(n), l = g();
            for (let r = 0; r < a.length; r += 1) a[r].c();
            u = g(), i = _("button"), i.textContent = "Vote"
        }, m(r, s) {
            C(r, e, s), f(e, o), C(r, l, s);
            for (let d = 0; d < a.length; d += 1) a[d] && a[d].m(r, s);
            C(r, u, s), C(r, i, s), h || (p = w(i, "click", t[2]), h = !0)
        }, p(r, s) {
            if (s & 1 && n !== (n = r[0].poll.question + "") && x(o, n), s & 1) {
                c = U(r[0].poll.voteOptions);
                let d;
                for (d = 0; d < c.length; d += 1) {
                    const y = fe(r, c, d);
                    a[d] ? a[d].p(y, s) : (a[d] = de(y), a[d].c(), a[d].m(u.parentNode, u))
                }
                for (; d < a.length; d += 1) a[d].d(1);
                a.length = c.length
            }
        }, d(r) {
            r && (O(e), O(l), O(u), O(i)), Z(a, r), h = !1, p()
        }
    }
}

function de(t) {
    let e, n, o, l = !1, u, i = t[8].caption + "", h, p, c, a;
    return p = $e(t[6][0]), {
        c() {
            e = _("label"), n = _("input"), u = g(), h = M(i), q(n, "type", "radio"), q(n, "name", "voteOption"), n.__value = o = t[8].caption, b(n, n.__value), p.p(n)
        }, m(r, s) {
            C(r, e, s), f(e, n), n.checked = n.__value === t[0].caption, f(e, u), f(e, h), c || (a = [w(n, "change", t[5]), w(n, "change", t[7])], c = !0)
        }, p(r, s) {
            s & 1 && o !== (o = r[8].caption) && (n.__value = o, b(n, n.__value), l = !0), (l || s & 1) && (n.checked = n.__value === r[0].caption), s & 1 && i !== (i = r[8].caption + "") && x(h, i)
        }, d(r) {
            r && O(e), p.r(), c = !1, S(a)
        }
    }
}

function Te(t) {
    let e, n, o, l, u, i, h, p, c, a, r, s = t[0].poll.question && pe(t);
    return {
        c() {
            e = _("div"), n = _("h2"), n.textContent = "Vote", o = g(), l = _("input"), u = g(), i = _("input"), h = g(), p = _("button"), p.textContent = "Load Poll", c = g(), s && s.c(), q(l, "placeholder", "Username"), q(i, "placeholder", "Poll Question")
        }, m(d, y) {
            C(d, e, y), f(e, n), f(e, o), f(e, l), b(l, t[0].username), f(e, u), f(e, i), b(i, t[0].question), f(e, h), f(e, p), f(e, c), s && s.m(e, null), a || (r = [w(l, "input", t[3]), w(i, "input", t[4]), w(p, "click", t[1])], a = !0)
        }, p(d, [y]) {
            y & 1 && l.value !== d[0].username && b(l, d[0].username), y & 1 && i.value !== d[0].question && b(i, d[0].question), d[0].poll.question ? s ? s.p(d, y) : (s = pe(d), s.c(), s.m(e, null)) : s && (s.d(1), s = null)
        }, i: k, o: k, d(d) {
            d && O(e), s && s.d(), a = !1, S(r)
        }
    }
}

function Fe(t, e, n) {
    let o = {username: "", caption: "", pollId: "", poll: {question: "", voteOptions: []}};

    async function l() {
        try {
            const r = await fetch(`http://localhost:8080/polls/question/${o.question}`);
            if (r.ok) {
                const s = await r.json();
                n(0, o.poll = s, o), n(0, o.pollId = s.pollId, o), n(0, o.caption = "", o)
            } else console.error("Failed to load poll")
        } catch (r) {
            console.error("Error:", r)
        }
    }

    const u = async () => {
        console.log("Creating vote with:", o);
        try {
            const r = await fetch("http://localhost:8080/votes", {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify({...o, caption: o.caption})
            });
            r.ok ? (console.log("Vote created", await r.json()), n(0, o = {
                username: "",
                caption: "",
                pollId: "",
                poll: {question: "", voteOptions: []}
            })) : console.error("Failed to create vote")
        } catch (r) {
            console.error("Error:", r)
        }
    }, i = [[]];

    function h() {
        o.username = this.value, n(0, o)
    }

    function p() {
        o.question = this.value, n(0, o)
    }

    function c() {
        o.caption = this.__value, n(0, o)
    }

    return [o, l, u, h, p, c, i, () => console.log("Selected value:", o.caption)]
}

class Be extends K {
    constructor(e) {
        super(), Q(this, e, Fe, Te, D, {})
    }
}

function Je(t) {
    let e, n, o, l, u, i, h, p, c;
    return l = new Ne({}), i = new Ve({}), p = new Be({}), {
        c() {
            e = _("div"), n = _("h1"), n.textContent = "Poll Application", o = g(), W(l.$$.fragment), u = g(), W(i.$$.fragment), h = g(), W(p.$$.fragment)
        }, m(a, r) {
            C(a, e, r), f(e, n), f(e, o), B(l, e, null), f(e, u), B(i, e, null), f(e, h), B(p, e, null), c = !0
        }, p: k, i(a) {
            c || (F(l.$$.fragment, a), F(i.$$.fragment, a), F(p.$$.fragment, a), c = !0)
        }, o(a) {
            H(l.$$.fragment, a), H(i.$$.fragment, a), H(p.$$.fragment, a), c = !1
        }, d(a) {
            a && O(e), J(l), J(i), J(p)
        }
    }
}

class De extends K {
    constructor(e) {
        super(), Q(this, e, null, Je, D, {})
    }
}

new De({target: document.getElementById("app")});
